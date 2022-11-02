package com.boot.common;


import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author YuanXin
 * @ClassName CommonTest
 * @Description TODO
 * @Date 2022/9/7 16:55
 */

public class CommonTest {

    @Test
    void creatPassword() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        System.out.println(passwordEncoder.encode("123456"));
    }
}
