package com.boot.security;

import cn.hutool.core.util.ObjectUtil;
import com.boot.dal.dao.User;
import com.boot.dal.repository.UserRepository;
import com.boot.security.eneity.SysUser;
import com.boot.security.exception.UserAuthenticationException;
import com.boot.wrappers.UserWrapper;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * @Author YuanXin
 * @ClassName UserDetailServiceImpl
 * @Description TODO
 * @Date 2022/9/5 18:00
 */
@Service
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    private final UserWrapper userWrapper;


    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.getByOpenId(username);
        if (ObjectUtil.isNotNull(user)) {
            SysUser sysUser = userWrapper.toSecurityUser(user);
            // TODO 权限
            return sysUser;
        } else {
            throw new UserAuthenticationException("用户未注册,请联系管理员");
        }
    }
}
