package com.boot.service;

import com.boot.dto.BackLoginRo;
import com.boot.dto.ChangePasswordRo;
import com.boot.dto.PhoneLoginRo;
import com.boot.dto.PhoneRegistryRo;


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

    /**
     * 修改密码
     *
     * @param ro
     * @return
     */
    Boolean changePassword(ChangePasswordRo ro);
}
