package com.boot.dal.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.common.dao.BaseTimeDeleteEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(value = "praise")
@Data
@TableName(value = "`praise`")
public class Praise extends BaseTimeDeleteEntity {

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private String userId;

    /**
     * 业务id
     */
    @ApiModelProperty(value = "业务id")
    private String otherId;

    /**
     * 点赞类型
     */
    @ApiModelProperty(value = "点赞类型")
    private String type;
}