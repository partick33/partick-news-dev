package com.partick.api.controller;

import com.partick.common.utils.RedisOperator;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author partick_peng
 */
public class BaseController {

    @Resource
    public RedisOperator redisOperator;

    public static final String MOBILE_SMSCODE = "mobile:smscode";

    /**
     * 获取BO中的错误信息
     * @param result
     * @return
     */
    public Map getErrors(BindingResult result) {
        Map<String, String> map = new HashMap<>();

        List<FieldError> errorList = result.getFieldErrors();

        for (FieldError error : errorList) {
            //发送验证错误的时候对应的某个属性
            String field = error.getField();
            //验证的错误信息
            String message = error.getDefaultMessage();
            map.put(field, message);
        }
        return map;
    }
}
