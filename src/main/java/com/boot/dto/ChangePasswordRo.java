package com.boot.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author YuanXin
 * @ClassName ChangePasswordRo
 * @Description TODO
 * @Date 2022/12/21 17:33
 */

@Data
public class ChangePasswordRo {

    @ApiModelProperty("用户id")
    private String userId;

    @NotBlank(message = "原密码不能为空")
    @ApiModelProperty("原密码")
    private String originPassword;

    @NotBlank(message = "新密码不能为空")
    @ApiModelProperty("新密码")

    private String password;

    @NotBlank(message = "请输入确认密码")
    @ApiModelProperty("确认密码")
    private String confirmPassword;
}
