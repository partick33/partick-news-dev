package com.partick.api.interceptor;

import com.partick.common.exception.CommonException;
import com.partick.common.result.ResponseStatusEnum;
import com.partick.common.utils.IPUtil;
import com.partick.common.utils.RedisOperator;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.partick.api.controller.BaseController.MOBILE_SMSCODE;

/**
 * @author partick_peng
 */
public class PassportInterceptor implements HandlerInterceptor {
    @Resource
    private RedisOperator redisOperator;

    /**
     * 拦截请求，访问Controller之前
     *
     * @param request
     * @param response
     * @param handler
     * @return false:请求被拦截 true:放行
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取用户IP
        String userIp = IPUtil.getRequestIp(request);
        //查看缓存是否存在
        boolean isExist = redisOperator.keyIsExist(MOBILE_SMSCODE + ":" + userIp);
        if (isExist) {
            CommonException.display(ResponseStatusEnum.SMS_NEED_WAIT_ERROR);
            return false;
        }
        return true;
    }

    /**
     * 请求访问到Controller之后，渲染视图之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 请求访问到Controller之后，渲染视图之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
