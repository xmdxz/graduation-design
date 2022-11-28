package com.boot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum Type {
    /**
     * 此项目中用于区分评论的类型
     */
    ORDER("订单"),
    GOODS("商品"),
    DYNAMIC("帖子");
    private String mark;
}
