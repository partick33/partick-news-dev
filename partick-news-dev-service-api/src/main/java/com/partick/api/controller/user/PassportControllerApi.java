package com.partick.api.controller.user;

import com.partick.common.result.CommonJsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author partick_peng
 */
@Api(value = "用户注册登录")
public interface PassportControllerApi {

    /**
     * 获取验证码
     * @param mobilePhone 手机号
     * @param code 验证码
     * @return
     */
    @ApiOperation(value = "获取验证码接口",notes = "获取验证码方法",httpMethod = "GET")
    @GetMapping("/getSmsCode")
    CommonJsonResult getSmsCode(String mobilePhone,String code);
}
