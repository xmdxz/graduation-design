package com.boot.dto.ro;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author YuanXin
 * @ClassName AddUserRo
 * @Description TODO
 * @Date 2022/11/14 15:17
 */

@Data
public class AddUserRo {


    @ApiModelProperty("昵称")
    @NotBlank(message = "请输入昵称")
    private String username;

    @NotBlank(message = "请输入手机号")
    @ApiModelProperty("手机号")
    private String phone;

    @NotBlank(message = "请输入密码")
    @ApiModelProperty("密码")
    private String password;

}