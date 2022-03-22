package com.partick.user.controller;

import com.partick.api.controller.user.HelloControllerApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author partick_peng
 */
@RestController
public class HelloController implements HelloControllerApi {

    final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Override
    public Object Hello() {
        return "hello init";
    }
}
