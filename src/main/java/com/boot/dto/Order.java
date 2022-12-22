package com.boot.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.enums.OrderStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author YuanXin
 * @ClassName Order
 * @Description TODO
 * @Date 2022/12/21 17:54
 */
@ApiModel(value = "`order`")
@Data
@TableName(value = "`order`")
public class Order extends BaseTimeDeleteEntity {
    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id")
    private String movieId;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private OrderStatus status;

    /**
     * 成交交易金额
     */
    @ApiModelProperty(value = "成交交易金额")
    private BigDecimal amount;

    /**
     * 购买人
     */
    @ApiModelProperty(value = "购买人")
    private String userId;
}