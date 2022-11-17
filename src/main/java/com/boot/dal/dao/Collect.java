package com.boot.dal.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.common.dao.BaseTimeDeleteEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(value = "`collect`")
@Data
@TableName(value = "`collect`")
public class Collect extends BaseTimeDeleteEntity {
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
}