package com.boot.dal.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.boot.common.dao.BaseTimeDeleteEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author YuanXin
 * @ClassName Goods
 * @Description TODO
 * @Date 2022/11/9 11:25
 */
@ApiModel(value = "goods")
@Data
@TableName(value = "`goods`")
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
    private String status;
}