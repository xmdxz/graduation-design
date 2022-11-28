package com.boot.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class UserDataVo {


    @ApiModelProperty("用户基本信息")
    private UserBasicInformation userInfo;


    @ApiModelProperty("收藏数")
    private Integer collect;

    @ApiModelProperty("贴子数")
    private Integer dynamic;

    @ApiModelProperty("我的发布")
    private Integer publish;

    @ApiModelProperty("我的卖出")
    private Integer sold;

    @ApiModelProperty("我的买入")
    private Integer buy;


}
