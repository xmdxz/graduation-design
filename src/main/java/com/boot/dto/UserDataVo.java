package com.boot.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class UserDataVo {


    @ApiModelProperty("用户基本信息")
    private UserBasicInformation userInfo;


    @ApiModelProperty("收藏数")
    private Integer collect;

    @ApiModelProperty("评论数")
    private Integer comment;

    @ApiModelProperty("可用优惠券")
    private Integer coupon;


}
