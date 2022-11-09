package com.boot.dal.repository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dal.dao.User;
import com.boot.dal.mapper.UserMapper;
import com.boot.dto.vo.UserDataVo;
import org.springframework.stereotype.Service;

/**
 * @Author YuanXin
 * @ClassName UserRepository
 * @Description
 * @Date 2022/8/28 11:56
 */

@Service
public class UserRepository extends ServiceImpl<UserMapper, User> {
    public User getByPhone(String phone) {
        return getOne(Wrappers.<User>lambdaQuery().eq(User::getPhone, phone));
    }

    public UserDataVo getData(String userId) {
        return baseMapper.getData(userId);
    }
}
