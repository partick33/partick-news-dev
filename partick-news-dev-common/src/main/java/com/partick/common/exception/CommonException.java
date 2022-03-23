package com.partick.common.exception;

import com.partick.common.result.ResponseStatusEnum;

/**
 * 日常异常统一封装
 * @author partick_peng
 */
public class CommonException {

    public static void display(ResponseStatusEnum responseStatusEnum) {
        throw new MyCommonException(responseStatusEnum);
    }
}
