package com.partick.user.controller;

import com.partick.api.controller.user.PassportControllerApi;
import com.partick.common.result.CommonJsonResult;
import com.partick.common.utils.SmsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author partick_peng
 */
@RestController
public class PassportController implements PassportControllerApi {

    final static Logger logger = LoggerFactory.getLogger(PassportController.class);

    @Resource
    private SmsUtils smsUtils;

    /**
     * 获取验证码
     *
     * @param mobilePhone 手机号
     * @param code        验证码
     * @return
     */
    @Override
    public CommonJsonResult getSmsCode(String mobilePhone, String code) {
        smsUtils.sendSMS(mobilePhone, code);
        return CommonJsonResult.ok();
    }
}
