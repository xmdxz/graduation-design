package com.boot.service.impl;

import com.boot.common.exception.ServiceException;
import com.boot.dal.dao.User;
import com.boot.dal.repository.UserRepository;
import com.boot.dto.common.vo.UserBasicInformation;
import com.boot.dto.vo.UserDataVo;
import com.boot.service.UserService;
import com.boot.wrappers.UserWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author YuanXin
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Date 2022/10/27 17:50
 */


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserWrapper userWrapper;


    private final UserRepository userRepository;

    @Override
    public UserBasicInformation getUserBasic(String userId) {
        User user = Optional.ofNullable(userRepository.getById(userId)).orElseThrow(() -> new ServiceException("用户不存在"));
        return userWrapper.toBasic(user);
    }

    @Override
    public UserDataVo data(String userId) {
        return userRepository.getData(userId);
    }
}
