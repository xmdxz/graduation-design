package com.boot.dto.common.vo;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Author YuanXin
 * @ClassName UserBasicInformation
 * @Description TODO
 * @Date 2022/9/11 16:10
 */

@Data
@Accessors(chain = true)
public class UserBasicInformation {

    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("头像")
    private String avatar;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    @Schema(description = "性别")
    private String sex;


    @ApiModelProperty(value = "个人简介")
    private String mark;
}
