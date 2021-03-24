package top.smartsoftware.smarthr.service;

/**
 * @Description
 * @Author xjx
 * @Date 2020-12-19
 */

import cn.hutool.json.JSONUtil;
import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.utils.BinaryUtil;
import com.aliyun.oss.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.smartsoftware.smarthr.config.OssConfig;
import top.smartsoftware.smarthr.model.OSSObjectVO;
import top.smartsoftware.smarthr.model.OssCallbackParam;
import top.smartsoftware.smarthr.model.OssCallbackResult;
import top.smartsoftware.smarthr.model.OssPolicyResult;
import top.smartsoftware.smarthr.utils.MimeTypeUtil;
import top.smartsoftware.smarthr.utils.DateTimeUtil;


import javax.servlet.http.HttpServletRequest;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


@Service
@CacheConfig(cacheNames = "oss_cache")
public class OssService {


    @Autowired
    private OssConfig ossConfig;

    @Autowired
    private OSSClient ossClient;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 签名生成
     */
    @CacheEvict(allEntries = true)
    public OssPolicyResult policy(String dir) {
        OssPolicyResult result = new OssPolicyResult();
        // 存储目录
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        //String dir = ossConfig.getALIYUN_OSS_DIR_PREFIX() + sdf.format(new Date());
        if (dir.endsWith("/")) {
            dir = dir.substring(0, dir.length() - 1);
        }
        // 签名有效期
        long expireEndTime = System.currentTimeMillis() + ossConfig.getALIYUN_OSS_EXPIRE() * 1000;
        Date expiration = new Date(expireEndTime);
        // 文件大小
        long maxSize = ossConfig.getALIYUN_OSS_MAX_SIZE() * 1024 * 1024;
        // 回调
        OssCallbackParam callback = new OssCallbackParam();
        callback.setCallbackUrl(ossConfig.getALIYUN_OSS_CALLBACK());
        callback.setCallbackBody("filename=${object}&size=${size}&mimeType=${mimeType}&height=${imageInfo.height}&width=${imageInfo.width}");
        callback.setCallbackBodyType("application/x-www-form-urlencoded");
        // 提交节点
        String action = "http://" + ossConfig.getALIYUN_OSS_BUCKET_NAME() + "." + ossConfig.getALIYUN_SZ_OSS_ENDPOINT();
        try {
            PolicyConditions policyConds = new PolicyConditions();
            policyConds.addConditionItem(PolicyConditions.COND_CONTENT_LENGTH_RANGE, 0, maxSize);
            policyConds.addConditionItem(MatchMode.StartWith, PolicyConditions.COND_KEY, dir);
            String postPolicy = ossClient.generatePostPolicy(expiration, policyConds);
            byte[] binaryData = postPolicy.getBytes("utf-8");
            String policy = BinaryUtil.toBase64String(binaryData);
            String signature = ossClient.calculatePostSignature(postPolicy);
            String callbackData = BinaryUtil.toBase64String(JSONUtil.parse(callback).toString().getBytes("utf-8"));
            // 返回结果
            result.setAccessKeyId(ossClient.getCredentialsProvider().getCredentials().getAccessKeyId());
            result.setPolicy(policy);
            result.setSignature(signature);
            result.setDir(dir);
            result.setCallback(callbackData);
            result.setHost(action);
        } catch (Exception e) {
        }
        return result;
    }

    @Cacheable
    public List<OSSObjectVO> getObjectList(String objectName) throws IOException {
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(ossConfig.getALIYUN_OSS_BUCKET_NAME());
        listObjectsRequest.setDelimiter("/");
        if (objectName != null && !"".equals(objectName)) {
            listObjectsRequest.setPrefix(objectName);
        }
        ObjectListing listing = ossClient.listObjects(listObjectsRequest);
        List<OSSObjectVO> ossObjectVOList = new ArrayList<>();
        for (String commonPrefix : listing.getCommonPrefixes()) {
            String substring = commonPrefix;
            if (objectName != null && !"".equals(objectName)) {
                substring = commonPrefix.substring(objectName.length());
            }
            OSSObjectVO ossObjectVO = new OSSObjectVO(substring);
            ossObjectVOList.add(ossObjectVO);
        }
        for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
            OSSObjectVO ossObjectVO = new OSSObjectVO();
            String contentType = MimeTypeUtil.getContentTypeBySuffix(objectSummary.getKey());
            Integer iconCode = MimeTypeUtil.toIconCode(contentType);
            String substring = objectSummary.getKey();
            if (objectName != null && !"".equals(objectName)) {
                substring = objectSummary.getKey().substring(objectName.length());
            }
            if (substring != null && !"".equals(substring)) {
                ossObjectVO.setKey(substring);
                String printSize = fileSizeConver(objectSummary.getSize());
                ossObjectVO.setSize(printSize);
                ossObjectVO.setLastModified(DateTimeUtil.dateToDateString(objectSummary.getLastModified(), "yyyy-MM-dd HH:mm:ss"));
                ossObjectVO.setOwner(objectSummary.getOwner().getId());
                ossObjectVO.setIsFolder(0);
                ossObjectVO.setContentType(contentType);
                ossObjectVO.setIconCode(iconCode);
                ossObjectVOList.add(ossObjectVO);
            }
        }
        return ossObjectVOList;
    }

    public String signUrl(String objectName, Integer expirationHours) {
        Date expiration = new Date(new Date().getTime() + 3600 * expirationHours * 1000);
        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(ossConfig.getALIYUN_OSS_BUCKET_NAME(), objectName, HttpMethod.GET);
        request.setExpiration(expiration);
        URL signedUrl = ossClient.generatePresignedUrl(request);
        System.out.println("signed url for getObject: " + signedUrl);
        String key = objectName + "_" + DateTimeUtil.getCurDateTime() + "_" + expirationHours;
        redisTemplate.opsForValue().set(key, signedUrl, expirationHours, TimeUnit.HOURS);
        return signedUrl.toString();
    }


    @CacheEvict(allEntries = true)
    public void deleteObject(String delObject) {
        if (delObject.endsWith("/")) {
            // 列举所有包含指定前缀的文件并删除。
            String nextMarker = null;
            ObjectListing objectListing = null;
            do {
                ListObjectsRequest listObjectsRequest = new ListObjectsRequest(ossConfig.getALIYUN_OSS_BUCKET_NAME())
                        .withPrefix(delObject)
                        .withMarker(nextMarker);

                objectListing = ossClient.listObjects(listObjectsRequest);
                if (objectListing.getObjectSummaries().size() > 0) {
                    List<String> keys = new ArrayList<String>();
                    for (OSSObjectSummary s : objectListing.getObjectSummaries()) {
                        System.out.println("key name: " + s.getKey());
                        keys.add(s.getKey());
                    }
                    DeleteObjectsRequest deleteObjectsRequest = new DeleteObjectsRequest(ossConfig.getALIYUN_OSS_BUCKET_NAME()).withKeys(keys);
                    ossClient.deleteObjects(deleteObjectsRequest);
                }

                nextMarker = objectListing.getNextMarker();
            } while (objectListing.isTruncated());
        } else {
            ossClient.deleteObject(ossConfig.getALIYUN_OSS_BUCKET_NAME(), delObject);
        }
    }

    public OssCallbackResult callback(HttpServletRequest request) {
        OssCallbackResult result = new OssCallbackResult();
        String filename = request.getParameter("filename");
        filename = "http://".concat(ossConfig.getALIYUN_OSS_BUCKET_NAME()).concat(".").concat(ossConfig.getALIYUN_OSS_ENDPOINT()).concat("/").concat(filename);
        result.setFilename(filename);
        result.setSize(request.getParameter("size"));
        result.setMimeType(request.getParameter("mimeType"));
        result.setWidth(request.getParameter("width"));
        result.setHeight(request.getParameter("height"));
        return result;
    }

    private static String fileSizeConver(long fileS) {
        DecimalFormat df = new DecimalFormat("#.00");
        String fileSizeString = "";
        String wrongSize = "0B";
        if (fileS == 0) {
            return wrongSize;
        }
        if (fileS < 1024) {
            fileSizeString = df.format((double) fileS) + "B";
        } else if (fileS < 1048576) {
            fileSizeString = df.format((double) fileS / 1024) + "KB";
        } else if (fileS < 1073741824) {
            fileSizeString = df.format((double) fileS / 1048576) + "MB";
        } else {
            fileSizeString = df.format((double) fileS / 1073741824) + "GB";
        }
        return fileSizeString;
    }

    @CacheEvict(allEntries = true)
    public void renameObject(String sourceObjectName, String destinationObjectName) {
        // 重命名=先拷贝再删除
        CopyObjectResult result = ossClient.copyObject(ossConfig.getALIYUN_OSS_BUCKET_NAME(), sourceObjectName, ossConfig.getALIYUN_OSS_BUCKET_NAME(), destinationObjectName);
        if (result != null) {
            ossClient.deleteObject(ossConfig.getALIYUN_OSS_BUCKET_NAME(), sourceObjectName);
        }
    }

    @CacheEvict(allEntries = true)
    public void newFolder(String newFolderName) {
        if (!newFolderName.endsWith("/")) {
            newFolderName += "/";
        }
        String content = "Hello OSS";
        PutObjectRequest putObjectRequest = new PutObjectRequest(ossConfig.getALIYUN_OSS_BUCKET_NAME(), newFolderName, new ByteArrayInputStream(content.getBytes()));
        ossClient.putObject(putObjectRequest);
    }
}

