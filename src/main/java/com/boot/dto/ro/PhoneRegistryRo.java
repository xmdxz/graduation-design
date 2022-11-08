package com.boot.dto.ro;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author YuanXin
 * @ClassName PhoneRegistryRo
 * @Description TODO
 * @Date 2022/11/8 16:42
 */

@Data
public class PhoneRegistryRo {


    @ApiModelProperty("手机号")
    @NotBlank(message = "手机号不能为空")
    private String phone;

    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "请输入密码")
    @ApiModelProperty("确认密码")
    private String surePassword;

}
