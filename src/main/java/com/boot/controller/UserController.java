package com.boot.controller;

import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.UserBasicInformation;
import com.boot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
@Api(tags = "个人中心")
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/deleteUser")
    @ApiOperation("删除用户")
    public Response<Boolean> delete(String id) {
        return ResponseUtil.success(userService.deleteUser(id));
    }

    @GetMapping("/basicInfo")
    @ApiOperation("获取用户个人基本信息")
    public Response<UserBasicInformation> getUserBasic(String userId) {
        return ResponseUtil.success(userService.getUserBasic(userId));
    }


    @PostMapping("/update")
    @ApiOperation("更新用户基本信息")
    public Response<Boolean> update(@RequestBody @Validated UserBasicInformation info) {
        return ResponseUtil.success(userService.update(info));
    }
}
