package com.boot.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Shubo_Yang
 * @version 1.0
 * @date 2022/11/7 14:47
 */
@AllArgsConstructor
@Getter
public enum CommentTypeEnum {
    GOODS("goods"),
    DYNAMIC("dynamic");
    String code;
}
