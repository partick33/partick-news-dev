package com.partick.user.controller;

import com.partick.api.controller.user.HelloControllerApi;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author partick_peng
 */
@RestController
public class HelloController implements HelloControllerApi {

    @Override
    public Object Hello() {
        return "hello init";
    }
}
