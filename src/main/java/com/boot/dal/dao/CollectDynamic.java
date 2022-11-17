package com.boot.dal.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.common.dao.BaseTimeDeleteEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(value = "collect_dynamic")
@Data
@TableName(value = "`collect_dynamic`")
public class CollectDynamic extends BaseTimeDeleteEntity {
    /**
     * 帖子id
     */
    @ApiModelProperty(value = "帖子id")
    private String dynamicId;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private String userId;
}