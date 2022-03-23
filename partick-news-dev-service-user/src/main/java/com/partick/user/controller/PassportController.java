package com.partick.user.controller;

import com.partick.api.controller.BaseController;
import com.partick.api.controller.user.PassportControllerApi;
import com.partick.common.enums.UserStatus;
import com.partick.common.result.CommonJsonResult;
import com.partick.common.result.ResponseStatusEnum;
import com.partick.common.utils.IPUtil;
import com.partick.common.utils.SmsUtils;
import com.partick.model.bo.RegisterLoginBO;
import com.partick.model.pojo.AppUser;
import com.partick.user.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;

/**
 * @author partick_peng
 */
@RestController
public class PassportController extends BaseController implements PassportControllerApi{

    final static Logger logger = LoggerFactory.getLogger(PassportController.class);

    @Resource
    private SmsUtils smsUtils;

    @Resource
    private UserService userService;

    /**
     * 获取验证码
     *
     * @param mobile 手机号
     * @param request 请求信息
     * @return
     */
    @Override
    public CommonJsonResult getSmsCode(@RequestParam String mobile, HttpServletRequest request) {
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

    /**
     * 一键注册登录
     *
     * @param registerLoginBO
     * @param result
     * @return
     */
    @Override
    public CommonJsonResult doLogin(@Valid RegisterLoginBO registerLoginBO, BindingResult result) {
        //判断BindingResult中是否保存了错误的验证信息，如果有，则需要返回
        if (result.hasErrors()) {
            Map map = getErrors(result);
            return CommonJsonResult.errorMap(map);
        }

        //校验验证码是否匹配
        String mobile = registerLoginBO.getMobile();
        String smsCode = registerLoginBO.getSmsCode();

        String redisSMSCode = redisOperator.get(MOBILE_SMSCODE + ":" + mobile);
        if (StringUtils.isBlank(redisSMSCode) || !redisSMSCode.equalsIgnoreCase(smsCode)) {
            return CommonJsonResult.errorCustom(ResponseStatusEnum.SMS_CODE_ERROR);
        }

        //查询数据库，判断该用户是否注册
        AppUser user = userService.queryMobileIsExist(mobile);
        boolean isEmpty = ObjectUtils.isEmpty(user);
        if (!isEmpty && user.getActiveStatus().equals(UserStatus.FROZEN.type)) {
            //如果用户不为空，并且状态为冻结，则直接抛出异常，禁止登录
            return CommonJsonResult.errorCustom(ResponseStatusEnum.USER_FROZEN);
        } else if (isEmpty) {
            //如果用户为空
            user = userService.createUser(mobile);
        }
        return CommonJsonResult.ok(user);
    }


}
