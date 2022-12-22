package com.boot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Type {
    /**
     * 业务类型枚举，
     */
    MOVIE("电影"),
    DYNAMIC("动态");
    String code;
}
