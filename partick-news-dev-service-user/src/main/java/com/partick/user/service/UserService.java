package com.partick.user.service;

import com.partick.model.pojo.AppUser;

/**
 * 用户Service层
 * @author partick_peng
 */
public interface UserService {

    /**
     * 查询用户是否存在
     * @param mobile
     * @return
     */
    AppUser queryMobileIsExist(String mobile);

    /**
     * 创建用户
     * @param mobile
     * @return
     */
    AppUser createUser(String mobile);
}
