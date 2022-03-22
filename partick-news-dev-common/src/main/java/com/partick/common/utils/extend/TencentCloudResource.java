package com.partick.common.utils.extend;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 腾讯云的相关信息
 * @author partick_peng
 */
@Component
@PropertySource("classpath:tencentCloud.properties")
@ConfigurationProperties(prefix = "tencentcloud")
public class TencentCloudResource {

    private String secretId;

    private String secretKey;

    private String smsSdkAppId;

    private String templateId;

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getSmsSdkAppId() {
        return smsSdkAppId;
    }

    public void setSmsSdkAppId(String smsSdkAppId) {
        this.smsSdkAppId = smsSdkAppId;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

}
