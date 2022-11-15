package com.boot.dto.ro;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Author YuanXin
 * @ClassName BackLoginRo
 * @Description TODO
 * @Date 2022/11/14 14:21
 */

@Data
public class BackLoginRo {


    @NotBlank(message = "用户名")
    private String username;

    @NotBlank(message = "密码")
    private String password;

}
