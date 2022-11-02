package com.boot.controller;

import com.boot.common.distance.LngLat;
import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.common.util.LngLatUtil;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author YuanXin
 * @ClassName CommonController
 * @Description TODO
 * @Date 2022/9/17 11:20
 */
@RestController
@Api(tags = "通用")
@AllArgsConstructor
public class CommonController {


    @GetMapping("/checkToken")
    public Response<Boolean> checkToken() {
        return ResponseUtil.success(true);
    }

    @PostMapping("/no/address")
    public Response<String> getAddress(@RequestBody LngLat ro) {
        return ResponseUtil.success(LngLatUtil.getAddress(ro.getPosition()));
    }
}
