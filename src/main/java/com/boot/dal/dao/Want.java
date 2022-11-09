package com.boot.dal.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.common.dao.BaseTimeDeleteEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author YuanXin
 * @ClassName Want
 * @Description TODO
 * @Date 2022/11/9 11:25
 */
@ApiModel(value = "want")
@Data
@TableName(value = "`want`")
public class Want extends BaseTimeDeleteEntity {

    /**
     * 想要的商品id
     */
    @ApiModelProperty(value = "想要的商品id")
    private String goodsId;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private String userId;
}