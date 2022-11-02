package com.boot.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.boot.common.enums.CacheKeyEnum;
import com.boot.common.exception.ServiceException;
import com.boot.common.util.RedisUtil;
import com.boot.dal.repository.UserRepository;
import com.boot.dto.common.ro.PhoneLoginRo;
import com.boot.dto.common.vo.LoginVo;
import com.boot.security.eneity.JwtConfig;
import com.boot.security.eneity.SysUser;
import com.boot.security.util.JwtUtil;
import com.boot.service.LoginService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @Author YuanXin
 * @ClassName LoginServiceImpl
 * @Description TODO
 * @Date 2022/9/5 18:11
 */

@Service
@AllArgsConstructor
@Log4j2
public class LoginServiceImpl implements LoginService {


    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginVo phone(PhoneLoginRo ro) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(ro.getPhone(), "123456");
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if (ObjectUtil.isNull(authenticate)) {
            throw new ServiceException("用户名或密码错误");
        }
        LoginVo loginVo = new LoginVo();
        SysUser sysUser = (SysUser) authenticate.getPrincipal();
        sysUser.getUser().setEndpoint(ro.getEndpoint());
        String token = JwtUtil.sign(sysUser.getUser().getPhone(), ro.getEndpoint(), sysUser.getUsername());
        loginVo.setToken(token);
        RedisUtil.put(CacheKeyEnum.USER_INFO.create(token), sysUser, JwtConfig.expire);
        return loginVo;
    }
}
