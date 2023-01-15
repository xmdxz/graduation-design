package com.boot.controller;

import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.CouponListVo;
import com.boot.service.CouponService;
import com.boot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @class: CouponController
 * @author: liyusheng
 * @description:
 * @date: 2023/1/14 23:52
 */
@RestController
@RequestMapping("coupon")
@Api(tags = "优惠卷")
public class CouponController {
    @Resource
    private CouponService couponService;

    @Resource
    private UserService userService;

    @GetMapping("getCouponByUserId")
    @ApiOperation("根据用户id获取优惠卷")
    public Response<CouponListVo> getCouponByUserId(String userId) {
        CouponListVo coupons = userService.coupons(userId);
        return ResponseUtil.success(coupons);
    }
}
