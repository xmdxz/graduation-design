package com.boot.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@ApiModel(value = "`user`")
@Schema
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "`user`", autoResultMap = true)
@Accessors(chain = true)
public class User extends BaseTimeDeleteEntity {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    @Schema(description = "用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    @Schema(description = "密码")
    private String password;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    @Schema(description = "手机号")
    private String phone;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    @Schema(description = "头像")
    private String avatar;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    @Schema(description = "性别")
    private Integer sex;


    @ApiModelProperty(value = "个人简介")
    private String mark;


    @ApiModelProperty("ip地址")
    private String ipAddress;
}