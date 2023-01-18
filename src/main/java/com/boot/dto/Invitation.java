package com.boot.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "`invitation`")
@Data
@TableName(value = "`invitation`")
public class Invitation extends BaseTimeDeleteEntity {

    @ApiModelProperty(value = "会员用户")
    private String userId;

    @ApiModelProperty(value = "被邀请用户")
    private String invitedUserId;

    @ApiModelProperty(value = "邀请码")
    private String invitationCode;
}
