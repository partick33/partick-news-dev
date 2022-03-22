package com.partick.common.utils;

import com.partick.common.utils.extend.TencentCloudResource;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 腾讯云短信服务工具类
 * @author partick_peng
 */
@Component
public class SmsUtils {

    @Resource
    private TencentCloudResource tencentCloudResource;

    public void sendSMS(String mobilePhone,String code) {
        try {
            // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
            // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
            Credential cred = new Credential(tencentCloudResource.getSecretId(), tencentCloudResource.getSecretKey());
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("sms.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            SmsClient client = new SmsClient(cred, "ap-guangzhou", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            SendSmsRequest req = new SendSmsRequest();
            String[] phoneNumberSet1 = {mobilePhone};
            req.setPhoneNumberSet(phoneNumberSet1);

            req.setSmsSdkAppId(tencentCloudResource.getSmsSdkAppId());
            //签名内容
            req.setSignName("夜独寒II个人公众号");
            req.setTemplateId(tencentCloudResource.getTemplateId());

            String[] templateParamSet1 = {code};
            req.setTemplateParamSet(templateParamSet1);

            // 返回的resp是一个SendSmsResponse的实例，与请求对象对应
            SendSmsResponse resp = client.SendSms(req);
            // 输出json格式的字符串回包
            System.out.println(SendSmsResponse.toJsonString(resp));

        } catch (TencentCloudSDKException e) {
            e.printStackTrace();
        }
    }
}
