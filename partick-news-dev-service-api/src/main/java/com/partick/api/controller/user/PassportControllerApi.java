package com.partick.api.controller.user;

import com.partick.common.result.CommonJsonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author partick_peng
 */
@Api(value = "用户注册登录")
@RequestMapping("passport")
public interface PassportControllerApi {

    /**
     * 获取验证码
     * @param mobile 手机号
     * @param request 请求信息
     * @return
     */
    @ApiOperation(value = "获取验证码接口",notes = "获取验证码方法",httpMethod = "GET")
    @GetMapping("/getSMSCode")
    CommonJsonResult getSmsCode(String mobile, HttpServletRequest request);
}
