package com.boot.security.eneity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author YuanXin
 * @ClassName JwtConfig
 * @Description TODO
 * @Date 2022/9/6 13:57
 */
@Component
@Data
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    public static String secret;

    public static Long expire;


    public static String tokenPrefix;

    public static String header;

    public void setHeader(String header) {
        JwtConfig.header = header;
    }

    public void setSecret(String secret) {
        JwtConfig.secret = secret;
    }

    public void setExpire(Long expire) {
        JwtConfig.expire = expire;
    }

    public void setTokenPrefix(String tokenPrefix) {
        JwtConfig.tokenPrefix = tokenPrefix;
    }
}
