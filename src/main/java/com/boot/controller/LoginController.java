package com.boot.controller;

import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.ChangePasswordRo;
import com.boot.dto.PhoneLoginRo;
import com.boot.dto.PhoneRegistryRo;
import com.boot.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@AllArgsConstructor
@Api(tags = "登录相关")
@RequestMapping("/login")
@RestController
@Valid
public class LoginController {

    private final LoginService loginService;


    @PostMapping(value = "/phone")
    @ApiOperation("登录")
    public Response<String> phone(@Validated @RequestBody PhoneLoginRo ro) {
        return ResponseUtil.success(loginService.phone(ro));
    }


    @PostMapping(value = "/change/password")
    @ApiOperation("修改密码")
    public Response<Boolean> changePassword(@Validated @RequestBody ChangePasswordRo ro) {
        return ResponseUtil.success(loginService.changePassword(ro));
    }

    @PostMapping(value = "/registry")
    @ApiOperation("注册")
    public Response<Boolean> registry(@Validated @RequestBody PhoneRegistryRo ro) {
        return ResponseUtil.success(loginService.registry(ro));
    }


}
