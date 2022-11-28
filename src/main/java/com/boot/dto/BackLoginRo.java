package com.boot.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class BackLoginRo {


    @NotBlank(message = "用户名")
    private String username;

    @NotBlank(message = "密码")
    private String password;

}
