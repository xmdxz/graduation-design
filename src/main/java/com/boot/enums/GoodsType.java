package com.boot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GoodsType {
    /**
     *
     */
    INVITATIONCODE("邀请码"),
    COUPON("邀请码");
    String mark;
}
