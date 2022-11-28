package com.boot.dao;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dto.User;
import com.boot.dto.UserBasicInformation;
import com.boot.dto.UserDataVo;
import com.boot.exception.ServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserRepository extends ServiceImpl<UserMapper, User> {


    public User getByPhone(String phone) {
        return getOne(Wrappers.<User>lambdaQuery().eq(User::getPhone, phone));
    }

    public UserBasicInformation getUserBasic(String userId) {
        User user = Optional.ofNullable(getById(userId)).orElseThrow(() -> new ServiceException("用户不存在"));
        UserBasicInformation userBasicInformation = new UserBasicInformation();
        BeanUtil.copyProperties(user, userBasicInformation, false);
        return userBasicInformation;
    }

    public UserDataVo getData(String userId) {
        return baseMapper.getData(userId);
    }
}
