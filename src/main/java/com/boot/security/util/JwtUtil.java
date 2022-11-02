package com.boot.security.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.boot.common.enums.EndpointEnum;
import com.boot.security.eneity.JwtConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: YuanXin
 */
@Slf4j
@Component
public class JwtUtil {
    /**
     * 记录在jwt Token中的用户名
     */
    private static final String TOKEN_ACCOUNT_KEY = "account";

    /**
     * 记录在jwt Token中的用户登录类型是web,app,微信,还是支付宝.
     */
    private static final String TOKEN_USER_LOGIN_ENDPOINT = "userEndpoint";

    /**
     * 校验token是否正确
     *
     * @param token 密钥
     * @return 是否正确
     */
    public static Map<String, Object> verify(String token, String account, EndpointEnum endpoint, String secret) {
        Map<String, Object> result = new HashMap<>(2);
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier;
            verifier = JWT.require(algorithm)
                    .withClaim(TOKEN_ACCOUNT_KEY, Base64.encode(account))
                    .withClaim(TOKEN_USER_LOGIN_ENDPOINT, endpoint.name())
                    .build();
            verifier.verify(token);
            result.put("isSuccess", true);
        } catch (Exception exception) {
            log.error("token验证时出现异常：" + exception.getMessage());
            result.put("isSuccess", false);
            result.put("exception", exception.getMessage());
        }
        return result;
    }

    public static <T> T getKeyInToken(String token, String key, Class<T> clazz) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim(key).as(clazz);
        } catch (JWTDecodeException e) {
            log.error(key + "解码失败, token 为" + token);
            throw new JWTDecodeException(key + "解码失败");
        }
    }

    public static String getAccount(String token) throws JWTDecodeException {
        String key = getKeyInToken(token, TOKEN_ACCOUNT_KEY, String.class);
        if (StrUtil.isNotBlank(key)) {
            return key;
        }
        return null;
    }

    /**
     * 生成签名,默认30min后过期
     *
     * @param user
     * @return 加密的token
     */
    public static String sign(String account, EndpointEnum endpoint, String secret) {
        return sign(account, endpoint, secret, JwtConfig.expire);
    }

    public static String sign(String account, EndpointEnum endpoint, String secret, long expireSecond) {
        try {
            //token过期时间
            Date date = new Date(System.currentTimeMillis() + (expireSecond * 1000));
            Algorithm algorithm = Algorithm.HMAC256(secret);

            String token = JWT.create()
                    .withClaim(TOKEN_ACCOUNT_KEY, Base64.encode(account))
                    .withClaim(TOKEN_USER_LOGIN_ENDPOINT, endpoint.name())
                    .withExpiresAt(date)
                    .sign(algorithm);

//            SpringTool.getBean(RedisUtil.class).put(CacheKeyEnum.LoginTokenKey.create(userContext.getAccount(), userContext.getUserType().name(), userContext.getEndpoint().name()),
//                    token, expireSecond);
            return token;
        } catch (Exception e) {
            log.error(e.toString());
            return null;
        }
    }

    public static Date getTokenExpiredTime(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getExpiresAt();
        } catch (JWTDecodeException e) {
            log.error("Token过期时间解析失败");
            throw new JWTDecodeException("Token过期时间解析失败");
        }
    }

    public static boolean needUpdateToke(String token) {
        //token过期时间
        long tokenExpireTime = JwtConfig.expire;
        Date currentTokenExpiredTime = getTokenExpiredTime(token);
        // 获取当前时间再过多久到过期时间
        long currentExpireTime = DateUtil.between(new Date(), currentTokenExpiredTime, DateUnit.SECOND, false);
        //　过半时则选择更新token
        return currentExpireTime > 0 && currentExpireTime < tokenExpireTime / 2;
    }

}
