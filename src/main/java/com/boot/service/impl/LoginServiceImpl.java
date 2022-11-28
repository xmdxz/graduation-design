package com.boot.service.impl;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ObjectUtil;
import com.boot.dao.UserRepository;
import com.boot.dto.BackLoginRo;
import com.boot.dto.PhoneLoginRo;
import com.boot.dto.PhoneRegistryRo;
import com.boot.dto.User;
import com.boot.exception.ServiceException;
import com.boot.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;


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
        return user.getId();
    }

    @Override
    public Boolean registry(PhoneRegistryRo ro) {
//        if (!CharSequenceUtil.equals(ro.getPassword(), ro.getSurePassword())) {
//            throw new ServiceException("两次密码输入不一致");
//        }
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
}
