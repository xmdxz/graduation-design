package com.boot.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author YuanXin
 * @ClassName GoodsStatus
 * @Description TODO
 * @Date 2022/11/9 17:17
 */

@Getter
@AllArgsConstructor
public enum GoodsStatus {

    NORMAL("正常"),
    SOLD("已卖出");

    private String mark;

}
