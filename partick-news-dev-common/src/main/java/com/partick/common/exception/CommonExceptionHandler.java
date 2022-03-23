package com.partick.common.exception;

import com.partick.common.result.CommonJsonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常拦截处理
 * 可以针对异常的类型进行捕获，然后返回Json信息到前端
 * @author partick_peng
 */
@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(MyCommonException.class)
    @ResponseBody
    public CommonJsonResult returnMyException(MyCommonException exception) {
        exception.printStackTrace();
        return CommonJsonResult.exception(exception.getResponseStatusEnum());
    }
}
