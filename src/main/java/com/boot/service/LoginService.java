package com.boot.service;

import com.boot.dto.common.ro.PhoneLoginRo;
import com.boot.dto.common.vo.LoginVo;

/**
 * @Author YuanXin
 * @ClassName LoginService
 * @Description TODO
 * @Date 2022/9/5 18:11
 */

public interface LoginService {

    /**
     * 手机号登陆
     *
     * @param ro
     * @return
     */

    LoginVo phone(PhoneLoginRo ro);
    
}
