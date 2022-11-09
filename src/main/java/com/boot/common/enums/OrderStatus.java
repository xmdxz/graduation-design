package com.boot.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author YuanXin
 * @ClassName OrderStatus
 * @Description TODO
 * @Date 2022/11/9 11:17
 */

@Getter
@AllArgsConstructor
public enum OrderStatus {

    FINISHED("已完成");
    
    private String mark;

}
