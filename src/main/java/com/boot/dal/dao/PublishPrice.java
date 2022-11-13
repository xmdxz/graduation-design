package com.boot.dal.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.common.dao.BaseTimeDeleteEntity;
import com.boot.dto.common.vo.UserBasicInformation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author YuanXin
 * @ClassName PublishPrice
 * @Description TODO
 * @Date 2022/11/13 11:37
 */
@ApiModel(value = "publish_price")
@Data
@TableName(value = "`publish_price`")
public class PublishPrice extends BaseTimeDeleteEntity {

    /**
     * 商品id
     */
    @ApiModelProperty(value = "商品id")
    private String goodsId;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private String userId;

    /**
     * 出价
     */
    @ApiModelProperty(value = "出价")
    private BigDecimal price;

    @ApiModelProperty("用户基本信息")
    @TableField(exist = false)
    private UserBasicInformation userInfo;
}