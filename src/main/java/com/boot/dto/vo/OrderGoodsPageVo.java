package com.boot.dto.vo;

import com.boot.common.enums.OrderStatus;
import com.boot.dto.common.vo.UserBasicInformation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author YuanXin
 * @ClassName OrderGoodsPageVo
 * @Description TODO
 * @Date 2022/11/9 17:51
 */


@Data
public class OrderGoodsPageVo {

    @ApiModelProperty("id")
    private String id;


    @ApiModelProperty("用户基本信息")
    private UserBasicInformation userInfo;
    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String name;

    /**
     * 商品图片
     */
    @ApiModelProperty(value = "商品图片")
    private List<String> images;

    /**
     * 商品描述
     */
    @ApiModelProperty(value = "商品描述")
    private String content;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private String userId;

    /**
     * 价格
     */
    @ApiModelProperty(value = "价格")
    private BigDecimal price;


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


}
