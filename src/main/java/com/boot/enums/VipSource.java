package com.boot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VipSource {

    /**
     *
     */
    PURCHASE("购买"),
    INVITATION("邀请");
    String mark;
}
