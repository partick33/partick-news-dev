package com.partick.user.service.impl;

import com.partick.model.pojo.AppUser;
import com.partick.user.mapper.AppUserMapper;
import com.partick.user.service.HelloService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author partick_peng
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Resource
    private AppUserMapper appUserMapper;

    /**
     * 测试查找用户
     *
     * @return
     */
    @Override
    public AppUser selectAppUser() {
        return appUserMapper.selectById(1001);
    }
}
