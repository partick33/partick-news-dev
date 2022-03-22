package com.partick.user.service;

import com.partick.model.pojo.AppUser;

/**
 * 整合MyBatisPlus测试
 * @author partick_peng
 */
public interface HelloService {

    /**
     * 测试查找用户
     * @return
     */
    AppUser selectAppUser();
}
