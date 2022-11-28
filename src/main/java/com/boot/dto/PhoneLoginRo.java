package com.boot.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Data
public class PhoneLoginRo {

    @ApiModelProperty("手机号")
    @NotBlank
    @Size(min = 11, max = 11, message = "手机号格式有误")
    private String phone;

    @NotBlank
    @ApiModelProperty("验证码")
    private String password;

}
