package com.boot.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author YuanXin
 * @ClassName UserAuthenticationException
 * @Description TODO
 * @Date 2022/9/7 16:15
 */


public class UserAuthenticationException extends AuthenticationException {

    public UserAuthenticationException(String msg) {
        super(msg);
    }
}
