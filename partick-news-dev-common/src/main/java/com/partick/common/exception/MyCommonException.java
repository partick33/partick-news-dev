package com.partick.common.exception;

import com.partick.common.result.ResponseStatusEnum;

/**
 * 自定义异常
 * @author partick_peng
 */
public class MyCommonException extends RuntimeException {
    private ResponseStatusEnum responseStatusEnum;

    public MyCommonException(ResponseStatusEnum responseStatusEnum) {
        super("异常状态码为：" + responseStatusEnum.status() + "；具体异常信息为：" + responseStatusEnum.msg());
        this.responseStatusEnum = responseStatusEnum;
    }

    public ResponseStatusEnum getResponseStatusEnum() {
        return responseStatusEnum;
    }

    public void setResponseStatusEnum(ResponseStatusEnum responseStatusEnum) {
        this.responseStatusEnum = responseStatusEnum;
    }
}
