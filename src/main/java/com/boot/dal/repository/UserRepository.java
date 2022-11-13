package com.boot.dal.repository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.common.exception.ServiceException;
import com.boot.dal.dao.User;
import com.boot.dal.mapper.UserMapper;
import com.boot.dto.common.vo.UserBasicInformation;
import com.boot.dto.vo.UserDataVo;
import com.boot.wrappers.UserWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author YuanXin
 * @ClassName UserRepository
 * @Description
 * @Date 2022/8/28 11:56
 */

@Service
@AllArgsConstructor
public class UserRepository extends ServiceImpl<UserMapper, User> {

    private final UserWrapper userWrapper;

    public User getByPhone(String phone) {
        return getOne(Wrappers.<User>lambdaQuery().eq(User::getPhone, phone));
    }

    public UserBasicInformation getUserBasic(String userId) {
        User user = Optional.ofNullable(getById(userId)).orElseThrow(() -> new ServiceException("用户不存在"));
        return userWrapper.toBasic(user);
    }

    public UserDataVo getData(String userId) {
        return baseMapper.getData(userId);
    }
}
