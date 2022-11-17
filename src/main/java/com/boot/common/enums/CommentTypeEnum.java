package com.boot.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommentTypeEnum {
    /**
     * 业务类型枚举，
     */
    GOODS("商品"),
    DYNAMIC("动态");
    String code;
}
