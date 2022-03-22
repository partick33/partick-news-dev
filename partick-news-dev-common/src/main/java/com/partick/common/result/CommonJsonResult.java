package com.partick.common.result;

import java.util.Map;

/**
 * 自定义响应数据类型枚举升级版本
 *
 * @author partick_peng
 * @Description: 自定义响应数据结构
 * 				本类可提供给 H5/ios/安卓/公众号/小程序 使用
 * 				前端接受此类数据（json object)后，可自行根据业务去实现相关功能
 **/
public class CommonJsonResult {

    /**
     * 响应业务状态码
     */
    private Integer status;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 响应数据，可以是Object，也可以是List或Map等
     */
    private Object data;

    /**
     * 成功返回，带有数据的，直接往OK方法丢data数据即可
     * @param data
     * @return
     */
    public static CommonJsonResult ok(Object data) {
        return new CommonJsonResult(data);
    }
    /**
     * 成功返回，不带有数据的，直接调用ok方法，data无须传入（其实就是null）
     * @return
     */
    public static CommonJsonResult ok() {
        return new CommonJsonResult(ResponseStatusEnum.SUCCESS);
    }
    public CommonJsonResult(Object data) {
        this.status = ResponseStatusEnum.SUCCESS.status();
        this.msg = ResponseStatusEnum.SUCCESS.msg();
        this.success = ResponseStatusEnum.SUCCESS.success();
        this.data = data;
    }


    /**
     * 错误返回，直接调用error方法即可，当然也可以在ResponseStatusEnum中自定义错误后再返回也都可以
     * @return
     */
    public static CommonJsonResult error() {
        return new CommonJsonResult(ResponseStatusEnum.FAILED);
    }

    /**
     * 错误返回，map中包含了多条错误信息，可以用于表单验证，把错误统一的全部返回出去
     * @param map
     * @return
     */
    public static CommonJsonResult errorMap(Map map) {
        return new CommonJsonResult(ResponseStatusEnum.FAILED, map);
    }

    /**
     * 错误返回，直接返回错误的消息
     * @param msg
     * @return
     */
    public static CommonJsonResult errorMsg(String msg) {
        return new CommonJsonResult(ResponseStatusEnum.FAILED, msg);
    }

    /**
     * 错误返回，token异常，一些通用的可以在这里统一定义
     * @return
     */
    public static CommonJsonResult errorTicket() {
        return new CommonJsonResult(ResponseStatusEnum.TICKET_INVALID);
    }

    /**
     * 自定义错误范围，需要传入一个自定义的枚举，可以到[ResponseStatusEnum.java[中自定义后再传入
     * @param responseStatus
     * @return
     */
    public static CommonJsonResult errorCustom(ResponseStatusEnum responseStatus) {
        return new CommonJsonResult(responseStatus);
    }
    public static CommonJsonResult exception(ResponseStatusEnum responseStatus) {
        return new CommonJsonResult(responseStatus);
    }

    public CommonJsonResult(ResponseStatusEnum responseStatus) {
        this.status = responseStatus.status();
        this.msg = responseStatus.msg();
        this.success = responseStatus.success();
    }
    public CommonJsonResult(ResponseStatusEnum responseStatus, Object data) {
        this.status = responseStatus.status();
        this.msg = responseStatus.msg();
        this.success = responseStatus.success();
        this.data = data;
    }
    public CommonJsonResult(ResponseStatusEnum responseStatus, String msg) {
        this.status = responseStatus.status();
        this.msg = msg;
        this.success = responseStatus.success();
    }

    public CommonJsonResult() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
