package com.boot.service.impl;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.boot.dao.UserRepository;
import com.boot.dto.*;
import com.boot.exception.ServiceException;
import com.boot.service.LoginService;
import com.boot.util.RequestUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor
@Log4j2
public class LoginServiceImpl implements LoginService {


    private final UserRepository userRepository;

    @Override
    public String phone(PhoneLoginRo ro) {
        User user = userRepository.getByPhone(ro.getPhone());
        if (ObjectUtil.isNull(user)) {
            throw new ServiceException("用户不存在");
        }
        if (!CharSequenceUtil.equals(ro.getPassword(), user.getPassword())) {
            throw new ServiceException("密码错误");
        }
        user.setIpAddress(RequestUtil.getIpAddr());
        userRepository.updateById(user);
        return user.getId();
    }

    @Override
    public Boolean registry(PhoneRegistryRo ro) {
        if (!CharSequenceUtil.equals(ro.getPassword(), ro.getSurePassword())) {
            throw new ServiceException("两次密码输入不一致");
        }
        String phone = ro.getPhone();
        User user = userRepository.getByPhone(phone);
        if (ObjectUtil.isNotNull(user)) {
            throw new ServiceException("手机号已被注册，请直接登录");
        }
        user = new User();
        user.setPhone(phone);
        user.setPassword(ro.getPassword());
        userRepository.save(user);
        return true;
    }

    @Override
    public String backLogin(BackLoginRo ro) {
        if (CharSequenceUtil.equals("admin", ro.getUsername()) && CharSequenceUtil.equals("123456", ro.getPassword())) {
            return "12332r7829384792832we399sdf1sad";
        } else {
            throw new ServiceException("用户名或密码错误");
        }
    }

    @Override
    public Boolean changePassword(ChangePasswordRo ro) {
        if (!StrUtil.equals(ro.getConfirmPassword(), ro.getPassword())) {
            throw new ServiceException("两次密码输入不一样");
        }
        User user = Optional.ofNullable(userRepository.getById(ro.getUserId())).orElseThrow(() -> new ServiceException("用户不存在"));
        if (!StrUtil.equals(user.getPassword(), ro.getOriginPassword())) {
            throw new ServiceException("原密码错误");
        }
        if (StrUtil.equals(ro.getPassword(), user.getPassword())) {
            throw new ServiceException("新密码不能与旧密码相同");
        }
        user.setPassword(ro.getPassword());
        return userRepository.updateById(user);
    }
}
