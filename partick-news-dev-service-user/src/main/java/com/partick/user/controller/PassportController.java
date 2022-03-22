package com.partick.user.controller;

import com.partick.api.controller.BaseController;
import com.partick.api.controller.user.PassportControllerApi;
import com.partick.common.result.CommonJsonResult;
import com.partick.common.utils.IPUtil;
import com.partick.common.utils.SmsUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author partick_peng
 */
@RestController
public class PassportController extends BaseController implements PassportControllerApi{

    final static Logger logger = LoggerFactory.getLogger(PassportController.class);

    @Resource
    private SmsUtils smsUtils;

    /**
     * 获取验证码
     *
     * @param mobile 手机号
     * @param request 请求信息
     * @return
     */
    @Override
    public CommonJsonResult getSmsCode(String mobile, HttpServletRequest request) {
        String userIp = IPUtil.getRequestIp(request);
        //根据用户的ip进行限制，限制用户在60秒内只能获取一次验证码
        redisOperator.setnx60s(MOBILE_SMSCODE + ":" + userIp, userIp);

        //生成随机验证码
        String code = String.valueOf((int) ((Math.random() * 9 + 1) * 100000));
        smsUtils.sendSMS(mobile, code);

        //把验证码存入redis，用于后续验证
        redisOperator.set(MOBILE_SMSCODE + ":" + mobile, code, 30 * 60);
        return CommonJsonResult.ok();
    }
}
