package com.boot.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.enums.GoodsType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@ApiModel(value = "`goods`")
@Data
@TableName(value = "`goods`")
public class Goods extends BaseTimeDeleteEntity {

    @ApiModelProperty(value = "商品类型")
    private GoodsType type;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "商品价格")
    private Integer price;

    @ApiModelProperty(value = "商品描述")
    private String mark;

    @ApiModelProperty(value = "商品数量：")
    private BigDecimal amount;
}
