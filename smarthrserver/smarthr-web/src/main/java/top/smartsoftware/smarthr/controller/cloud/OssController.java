package top.smartsoftware.smarthr.controller.cloud;

/**
 * @Description
 * @Author xjx
 * @Date 2020-12-19
 */

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.smartsoftware.smarthr.model.*;
import top.smartsoftware.smarthr.service.OperationLogService;
import top.smartsoftware.smarthr.service.OssService;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cloud/oss")
public class OssController {
    @Autowired
    private OssService ossService;

    @RequestMapping(value = "/policy", method = RequestMethod.GET)
    public RespBean policy(String dir) {
        OssPolicyResult result = ossService.policy(dir);
        return RespBean.ok(result);
    }

    @RequestMapping(value = "/ocrPolicy", method = RequestMethod.GET)
    public RespBean ocrPolicy(String dir) {
        OssPolicyResult result = ossService.ocrPolicy(dir);
        return RespBean.ok(result);
    }


    @RequestMapping(value = "callback", method = RequestMethod.POST)
    public RespBean callback(HttpServletRequest request) {
        OssCallbackResult ossCallbackResult = ossService.callback(request);
        return RespBean.ok(ossCallbackResult);
    }


    @RequestMapping(value = "/deleteObject", method = RequestMethod.GET)
    public RespBean deleteObject(String delObject) {
        ossService.deleteObject(delObject);
        OperationLogService.insertLog(new OperationLog("删除了OSS文件："+delObject,1));
        return RespBean.ok("删除成功");
    }

    @RequestMapping(value = "/renameObject", method = RequestMethod.GET)
    public RespBean renameObject(String sourceObjectName, String destinationObjectName) {
        ossService.renameObject(sourceObjectName, destinationObjectName);
        OperationLogService.insertLog(new OperationLog("重命名了OSS文件："+sourceObjectName+"->"+destinationObjectName,2));
        return RespBean.ok();
    }

    @RequestMapping(value = "/newFolder", method = RequestMethod.GET)
    public RespBean newFolder(String newFolderName) {
        ossService.newFolder(newFolderName);
        OperationLogService.insertLog(new OperationLog("新建了OSS文件夹："+newFolderName,0));
        return RespBean.ok();
    }


    @RequestMapping(value = "/getObjectList", method = RequestMethod.GET)
    public RespBean getObjectList(String objectName) throws IOException {
        List<OSSObjectVO> objectList = ossService.getObjectList(objectName);
        return RespBean.ok(objectList);
    }

    @RequestMapping(value = "/signUrl", method = RequestMethod.GET)
    public RespBean signUrl(String objectName, Integer expirationHours) {
        String signUrl = ossService.signUrl(objectName, expirationHours);
        OperationLogService.insertLog(new OperationLog("生成了OSS文件下载链接："+objectName,0));
        return RespBean.ok((Object) signUrl);
    }

    @RequestMapping(value = "/idCardOcrSignUrl", method = RequestMethod.GET)
    public RespBean idCardOcrSignUrl(String objectName, Integer expirationHours) {
        JSONObject idCardVO = ossService.idCardOcrSignUrl(objectName, expirationHours);
        OperationLogService.insertLog(new OperationLog("调用了身份证识别："+idCardVO,0));
        return RespBean.ok(idCardVO);
    }

    @RequestMapping(value = "/bankCardOcrSignUrl", method = RequestMethod.GET)
    public RespBean bankCardOcrSignUrl(String objectName, Integer expirationHours) {
        JSONObject bankCardVO = ossService.bankCardOcrSignUrl(objectName, expirationHours);
        OperationLogService.insertLog(new OperationLog("调用了银行卡识别："+bankCardVO,0));
        return RespBean.ok(bankCardVO);
    }

}

