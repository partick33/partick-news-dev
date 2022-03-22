package com.partick.api.controller;

import com.partick.common.utils.RedisOperator;

import javax.annotation.Resource;

/**
 * @author partick_peng
 */
public class BaseController {

    @Resource
    public RedisOperator redisOperator;

    public static final String MOBILE_SMSCODE = "mobile:smscode";
}
