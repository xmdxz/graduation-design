package com.boot.controller;

import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.common.vo.UserBasicInformation;
import com.boot.dto.vo.UserDataVo;
import com.boot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author YuanXin
 * @ClassName UserController
 * @Description TODO
 * @Date 2022/11/8 16:59
 */

@RestController
@RequestMapping("/user")
@Api(tags = "个人中心")
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @RequestMapping("/basicInfo")
    @ApiOperation("获取用户个人基本信息")
    public Response<UserBasicInformation> getUserBasic(String userId) {
        return ResponseUtil.success(userService.getUserBasic(userId));
    }

    @GetMapping("/data")
    @ApiOperation("获取我的页面的数据")
    public Response<UserDataVo> data(String userId) {
        return ResponseUtil.success(userService.data(userId));
    }
}
