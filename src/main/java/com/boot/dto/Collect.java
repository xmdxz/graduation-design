package com.boot.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.enums.Type;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author YuanXin
 * @ClassName Collect
 * @Description TODO
 * @Date 2022/12/21 17:12
 */
@ApiModel(value = "`collect`")
@Data
@TableName(value = "`collect`")
public class Collect extends BaseTimeDeleteEntity {

    /**
     * 业务id
     */
    @ApiModelProperty(value = "业务id")
    private String typeId;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private String userId;

    /**
     * 收藏类型
     */
    @ApiModelProperty(value = "收藏类型")
    private Type type;
}