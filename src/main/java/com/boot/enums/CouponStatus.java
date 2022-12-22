package com.boot.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author YuanXin
 * @ClassName CouponStatus
 * @Description TODO
 * @Date 2022/12/21 17:19
 */
@Getter
@AllArgsConstructor
public enum CouponStatus {

    NORMAL("正常"),
    EXPIRED("已过期"),
    
    USED("已使用");

    private String mark;


}
