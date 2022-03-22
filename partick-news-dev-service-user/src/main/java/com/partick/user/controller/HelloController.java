package com.partick.user.controller;

import com.partick.api.controller.user.HelloControllerApi;
import com.partick.common.result.CommonJsonResult;
import com.partick.model.pojo.AppUser;
import com.partick.user.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author partick_peng
 */
@RestController
public class HelloController implements HelloControllerApi {

    final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Resource
    private HelloService helloService;

    @Override
    public Object Hello() {
        AppUser appUser = helloService.selectAppUser();
        return CommonJsonResult.ok(appUser);
    }
}
