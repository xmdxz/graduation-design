package com.boot.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author YuanXin
 * @ClassName CacheKeyEnum
 * @Description TODO
 * @Date 2022/9/6 15:10
 */


@AllArgsConstructor
@Getter
public enum CacheKeyEnum {


    LOGIN_TOKEN("TOKEN"),
    USER_INFO("USER");


    private static final String CONNECTOR = "#";

    private final String prefix;

    public String create(String... key) {
        StringBuilder sb = new StringBuilder(this.prefix);
        for (String s : key) {
            sb.append(CONNECTOR).append(s);
        }
        return sb.toString();
    }
}
