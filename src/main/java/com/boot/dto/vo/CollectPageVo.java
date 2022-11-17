package com.boot.dto.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.boot.dto.common.vo.UserBasicInformation;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
public class CollectPageVo {

    @ApiModelProperty("用户基本信息")
    private UserBasicInformation userInfo;


    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id")
    private String goodsId;

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
     * 价格
     */
    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty("id")
    private String id;


}
