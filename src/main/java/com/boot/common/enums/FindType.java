package com.boot.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author YuanXin
 * @ClassName FindType
 * @Description TODO
 * @Date 2022/11/9 17:54
 */

@Getter
@AllArgsConstructor
public enum FindType {


    SOLD("我卖出的"),
    BUY("我买入的");
    private String mark;

}
