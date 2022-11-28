package com.boot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FindType {

    /**
     *
     */
    SOLD("我卖出的"),
    BUY("我买入的");
    private String mark;

}
