package com.boot.dal.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.common.dao.BaseTimeDeleteEntity;
import com.boot.common.enums.OrderStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author YuanXin
 * @ClassName Order
 * @Description TODO
 * @Date 2022/11/9 10:59
 */
@ApiModel(value = "`order`")
@Data
@TableName(value = "`order`")
public class Order extends BaseTimeDeleteEntity {
    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id")
    private String goodsId;

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

    /**
     * 卖出人
     */
    @ApiModelProperty(value = "卖出人")
    private String goodsUserId;
}