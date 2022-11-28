package com.boot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.boot.dao.UserRepository;
import com.boot.dto.User;
import com.boot.dto.UserBasicInformation;
import com.boot.exception.ServiceException;
import com.boot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserBasicInformation getUserBasic(String userId) {
        User user = Optional.ofNullable(userRepository.getById(userId)).orElseThrow(() -> new ServiceException("用户不存在"));
        UserBasicInformation target = new UserBasicInformation();
        BeanUtil.copyProperties(user, target, false);
        return target;
    }

    @Override
    public Boolean deleteUser(String id) {
        return userRepository.removeById(id);
    }

    @Override
    public Boolean update(UserBasicInformation info) {
        String userId = info.getId();
        User user = Optional.ofNullable(userRepository.getById(userId)).orElseThrow(() -> new ServiceException("用户不存在"));
        user.setAvatar(info.getAvatar());
        user.setUsername(info.getUsername());
        user.setMark(info.getMark());
        user.setSex(info.getSex());
        return userRepository.updateById(user);
    }
}

