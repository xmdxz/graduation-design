package com.boot.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum GoodsStatus {

    /**
     * 商品状态
     */
    NORMAL("正常"),
    SOLD("已卖出");

    private String mark;

}
