package com.boot.dal.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.boot.common.dao.BaseTimeDeleteEntity;
import com.boot.common.enums.GoodsStatus;
import com.boot.dto.common.vo.UserBasicInformation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@ApiModel(value = "goods")
@Data
@TableName(value = "`goods`", autoResultMap = true)
public class Goods extends BaseTimeDeleteEntity {
    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String name;

    /**
     * 商品图片
     */
    @ApiModelProperty(value = "商品图片")
    @TableField(typeHandler = JacksonTypeHandler.class)
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
    private GoodsStatus status;

    @ApiModelProperty("用户信息")
    @TableField(exist = false)
    private UserBasicInformation userInfo;
}