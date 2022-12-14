package com.boot.controller;

import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.common.ro.PhoneLoginRo;
import com.boot.dto.common.vo.LoginVo;
import com.boot.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @Author YuanXin
 * @ClassName LoginController
 * @Description TODO
 * @Date 2022/9/5 18:10
 */

@AllArgsConstructor
@Api(tags = "登录相关")
@RequestMapping("/login")
@RestController
@Valid
public class LoginController {

    private final LoginService loginService;


    @PostMapping(value = "/phone")
    @ApiOperation("登录")
    public Response<LoginVo> phone(@Validated PhoneLoginRo ro) {
        return ResponseUtil.success(loginService.phone(ro));
    }


}
