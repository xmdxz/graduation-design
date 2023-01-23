package com.boot.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.boot.enums.VipSource;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@ApiModel(value = "`vip`")
@Data
@TableName(value = "`vip`")
public class Vip extends BaseTimeDeleteEntity {

    @ApiModelProperty(value = "会员用户")
    private String userId;

    @ApiModelProperty(value = "会员来源")
    private VipSource source;

    @ApiModelProperty(value = "是否邀请过用户")
    private Integer invited;

    @ApiModelProperty(value = "积分")
    private Integer integral;

}
