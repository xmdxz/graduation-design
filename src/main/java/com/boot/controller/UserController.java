package com.boot.controller;

import com.boot.common.response.Response;
import com.boot.dto.common.vo.UserBasicInformation;
import com.boot.service.UserService;
import io.swagger.annotations.Api;
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


    @GetMapping("获取用户个人基本信息")
    private Response<UserBasicInformation> getUserBasic() {
        return null;
    }

}
