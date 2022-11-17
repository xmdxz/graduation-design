package com.boot.service;

import com.boot.dto.common.ro.PhoneLoginRo;
import com.boot.dto.ro.BackLoginRo;
import com.boot.dto.ro.PhoneRegistryRo;


public interface LoginService {

    /**
     * 手机号登陆
     *
     * @param ro
     * @return
     */

    String phone(PhoneLoginRo ro);

    /**
     * 注册
     *
     * @param ro
     * @return
     */
    Boolean registry(PhoneRegistryRo ro);

    String backLogin(BackLoginRo ro);
}
