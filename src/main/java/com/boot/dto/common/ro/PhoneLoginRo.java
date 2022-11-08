package com.boot.dto.common.ro;

import com.boot.common.enums.EndpointEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @Author YuanXin
 * @ClassName PhoneLoginRo
 * @Description TODO
 * @Date 2022/9/7 16:20
 */

@Data
public class PhoneLoginRo {

    @ApiModelProperty("手机号")
    @NotBlank
    @Size(min = 11, max = 11, message = "手机号格式有误")
    private String phone;

    @NotBlank
    @ApiModelProperty("验证码")
    private String password;

    @ApiModelProperty("登录设备")
    private EndpointEnum endpoint;
}
