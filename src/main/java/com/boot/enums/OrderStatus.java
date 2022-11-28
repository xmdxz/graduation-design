package com.boot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum OrderStatus {
    /**
     * 订单状态
     */
    FINISHED("已完成");

    private String mark;

}
