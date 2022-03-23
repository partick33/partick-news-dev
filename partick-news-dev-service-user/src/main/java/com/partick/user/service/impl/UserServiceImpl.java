package com.partick.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.partick.common.enums.Sex;
import com.partick.common.enums.UserStatus;
import com.partick.common.utils.DateUtil;
import com.partick.common.utils.DesensitizationUtil;
import com.partick.common.utils.UuidUtil;
import com.partick.model.pojo.AppUser;
import com.partick.user.mapper.AppUserMapper;
import com.partick.user.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author partick_peng
 */
@Service
public class UserServiceImpl implements UserService {

    private static final String FACE_IMG="https://c-ssl.duitang.com/uploads/item/202005/18/20200518080041_cgwpv.png";

    @Resource
    private AppUserMapper appUserMapper;

    /**
     * 查询用户是否存在
     *
     * @param mobile
     * @return
     */
    @Override
    public AppUser queryMobileIsExist(String mobile) {
        QueryWrapper<AppUser> queryWrapper = new QueryWrapper<AppUser>();
        queryWrapper.eq("mobile", mobile);
        AppUser user = appUserMapper.selectOne(queryWrapper);
        return user;
    }

    /**
     * 创建用户
     *
     * @param mobile
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public AppUser createUser(String mobile) {
        AppUser user = new AppUser();
        user.setId(UuidUtil.getShortUuid());
        user.setMobile(mobile);
        user.setNickname("用户：" + DesensitizationUtil.commonDisplay(mobile));
        user.setFace(FACE_IMG);
        user.setBirthday(DateUtil.stringToDate("2000-01-01"));
        user.setSex(Sex.secret.type);
        user.setActiveStatus(UserStatus.INACTIVE.type);
        user.setTotalIncome(0);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        appUserMapper.insert(user);
        return user;
    }
}
