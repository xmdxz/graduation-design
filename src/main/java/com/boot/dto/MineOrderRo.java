package com.boot.dto;

import com.boot.common.request.page.PageQuery;
import com.boot.enums.OrderStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author YuanXin
 * @ClassName MineOrderRo
 * @Description TODO
 * @Date 2022/12/22 11:05
 */

@Data
public class MineOrderRo {

    private PageQuery page;


    @ApiModelProperty("订单状态")
    private OrderStatus status;

    private String userId;
}
