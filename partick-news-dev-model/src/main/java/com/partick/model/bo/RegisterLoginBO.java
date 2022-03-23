package com.partick.model.bo;

import javax.validation.constraints.NotBlank;

/**
 * @author partick_peng
 */
public class RegisterLoginBO {
    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    private String mobile;
    /**
     * 验证码
     */
    @NotBlank(message = "短信验证码不能为空")
    private String smsCode;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }

    @Override
    public String toString() {
        return "RegisterLoginBO{" +
                "mobile='" + mobile + '\'' +
                ", smsCode='" + smsCode + '\'' +
                '}';
    }
}
