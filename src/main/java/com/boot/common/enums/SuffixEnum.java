package com.boot.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

/**
 * @Author YuanXin
 * @ClassName SuffixEnum
 * @Description TODO
 * @Date 2022/8/11 15:12
 */

@AllArgsConstructor
@Getter
public enum SuffixEnum {

    /**
     * 项目中常用单位
     */
    CELSIUS("°C", null),

    M("米", null),
    KM("千米", null),
    /**
     * 需要单位转换的
     */
    GE("个", new BigDecimal(10000)),
    WAN("万", new BigDecimal(100000000));

    private final String mark;

    /**
     * 上界
     */
    private final BigDecimal high;


}
