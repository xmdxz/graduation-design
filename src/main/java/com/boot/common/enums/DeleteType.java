package com.boot.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author YuanXin
 * @ClassName DeleteType
 * @Description TODO
 * @Date 2022/11/12 13:06
 */
@Getter
@AllArgsConstructor
public enum DeleteType {
    ORDER("订单"),
    GOODS("商品"),
    DYNAMIC("帖子");
    private String mark;
}
