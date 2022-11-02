package com.boot.common.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisServerCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author TateBrown
 * @date 2021/1/12 1:45 下午
 * <p>
 * redisTemplate封装
 * <p>
 * todo 目前只需要使用普通缓存故只封装普通缓存
 */
@Slf4j
public class RedisUtil {
    private static RedisTemplate<String, Object> redisTemplate;

    public static void setRedisTemplate(RedisTemplate<String, Object> template) {
        redisTemplate = template;
    }

    /**
     * 指定缓存失效时间
     *
     * @param key  键
     * @param time 时间
     * @return 指定缓存失效时间是否成功
     */
    public static boolean expire(String key, long time) {
        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 上锁
     * 底层是redis的setNx方法
     *
     * @param key     键
     * @param value   值
     * @param timeout 超市时间，单位秒
     * @return 上锁是否成功
     */
    public static boolean tryLock(String key, Object value, long timeout) {
        boolean isSuccess = Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(key, value));
        if (isSuccess) {
            redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        }
        return isSuccess;
    }

    /**
     * 释放锁
     *
     * @param key 键
     */
    public static void unLock(String key) {
        String value = (String) redisTemplate.opsForValue().get(key);
        if (ObjectUtil.isNotNull(value)
                && value.equals(IpUtil.getLocalhostIp())) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 根据key返回过期时间
     *
     * @param key 键，不能为null
     * @return 时间（秒） 返回0代表永久有效
     */
    public static long getExpire(String key) {
        return Optional.ofNullable(redisTemplate.getExpire(key, TimeUnit.SECONDS)).orElse(0L);
    }

    /**
     * 是否含有某个键
     *
     * @param key 键
     * @return key是否存在
     */
    public static boolean hasKey(String key) {
        try {
            return Optional.ofNullable(redisTemplate.hasKey(key)).orElse(false);
        } catch (Exception e) {
            log.error(e.getMessage());
            return false;
        }
    }

    /**
     * 删除缓存
     *
     * @param key 要删除的键
     */
    public static void del(String... key) {
        if (ObjectUtil.isNotEmpty(key)
                && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(Arrays.asList(key));
            }
        }
    }

    /**
     * 放入缓存
     *
     * @param key   key
     * @param value value
     */
    public static void put(String key, Object value) {
        if (StrUtil.isNotBlank(key) && ObjectUtil.isNotNull(value)) {
            redisTemplate.opsForValue().set(key, value);
        }
    }

    /**
     * 放入缓存
     *
     * @param key     key
     * @param value   value
     * @param timeout 过期时间，单位s,如果time小于等于0，将设置无限期
     */
    public static void put(String key, Object value, long timeout) {
        if (StrUtil.isNotBlank(key) && ObjectUtil.isNotNull(value)) {
            if (timeout > 0) {
                redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
            } else {
                redisTemplate.opsForValue().set(key, value);
            }
        }
    }

    /**
     * 获取缓存，不刷新过期时间
     *
     * @param key key
     * @return value
     */
    public static Object get(String key) {
        return StrUtil.isBlank(key) ? null :
                redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取指定类型值，不存在则返回null
     *
     * @param key   key
     * @param clazz 类型
     * @return value
     */
    public static <T> T getObject(String key, Class<T> clazz) {
        Object value = get(key);
        T ret = null;
        if (ObjectUtil.isNotNull(value) && clazz.isInstance(value)) {
            ret = (T) value;
        }
        return ret;
    }

    /**
     * 获取指定类型值，不存在则返回默认值
     *
     * @param key          key
     * @param defaultValue defaultValue
     * @param clazz        类型
     * @return value
     */
    public static <T> T getObjectWithDefault(String key, T defaultValue, Class<T> clazz) {
        Object value = get(key);
        T ret = defaultValue;
        if (ObjectUtil.isNotNull(value) && clazz.isInstance(value)) {
            ret = (T) value;
        }
        return ret;
    }

    /**
     * 获取list值，不存在则返回默认值
     *
     * @param key          key
     * @param defaultValue 默认值
     * @return value
     */
    public static <T> List<T> getListWithDefault(String key, List<T> defaultValue) {
        Object value = get(key);
        List<T> ret = defaultValue;
        if (ObjectUtil.isNotNull(value) && value instanceof List) {
            ret = (List<T>) value;
        }
        return ret;
    }

    /**
     * @param pattern 模式匹配串
     * @return 所有key的集合
     */
    public static Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }


    public static int getSize() {
        return Objects.requireNonNull(redisTemplate.execute((RedisCallback<Long>) RedisServerCommands::dbSize)).intValue();
    }

}
