package top.smartsoftware.smarthr.config;

import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description
 * @Author xjx
 * @Date 2020-12-19
 */
@Configuration
public class OssConfig {
    @Value("${aliyun.oss.shenzhenEndpoint}")
    private String ALIYUN_SZ_OSS_ENDPOINT;

    @Value("${aliyun.oss.endpoint}")
    private String ALIYUN_OSS_ENDPOINT;

    @Value("${aliyun.oss.accessKeyId}")
    private String ALIYUN_OSS_ACCESSKEYID;

    @Value("${aliyun.oss.accessKeySecret}")
    private String ALIYUN_OSS_ACCESSKEYSECRET;

    @Value("${aliyun.oss.bucketName}")
    private String ALIYUN_OSS_BUCKET_NAME;

    @Value("${aliyun.oss.policy.expire}")
    private Integer ALIYUN_OSS_EXPIRE;

    @Value("${aliyun.oss.maxSize}")
    private Integer ALIYUN_OSS_MAX_SIZE;

    @Value("${aliyun.oss.callback}")
    private String ALIYUN_OSS_CALLBACK;

    @Value("${aliyun.oss.dir.prefix}")
    private String ALIYUN_OSS_DIR_PREFIX;

    public String getALIYUN_OSS_ENDPOINT() {
        return ALIYUN_OSS_ENDPOINT;
    }

    public String getALIYUN_OSS_ACCESSKEYID() {
        return ALIYUN_OSS_ACCESSKEYID;
    }

    public String getALIYUN_OSS_ACCESSKEYSECRET() {
        return ALIYUN_OSS_ACCESSKEYSECRET;
    }

    public String getALIYUN_OSS_BUCKET_NAME() {
        return ALIYUN_OSS_BUCKET_NAME;
    }

    public Integer getALIYUN_OSS_EXPIRE() {
        return ALIYUN_OSS_EXPIRE;
    }

    public Integer getALIYUN_OSS_MAX_SIZE() {
        return ALIYUN_OSS_MAX_SIZE;
    }

    public String getALIYUN_OSS_CALLBACK() {
        return ALIYUN_OSS_CALLBACK;
    }

    public String getALIYUN_OSS_DIR_PREFIX() {
        return ALIYUN_OSS_DIR_PREFIX;
    }

    public String getALIYUN_SZ_OSS_ENDPOINT() {
        return ALIYUN_SZ_OSS_ENDPOINT;
    }

    @Bean
    public OSSClient ossClient() {
        return new OSSClient(ALIYUN_OSS_ENDPOINT, ALIYUN_OSS_ACCESSKEYID, ALIYUN_OSS_ACCESSKEYSECRET);
    }
}