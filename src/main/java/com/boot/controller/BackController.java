package com.boot.controller;

import com.boot.common.request.page.PageQuery;
import com.boot.common.request.page.PageResult;
import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.*;
import com.boot.service.BackService;
import com.boot.service.LoginService;
import com.boot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author YuanXin
 * @ClassName BackController
 * @Description TODO
 * @Date 2022/12/28 20:21
 */

@RestController
@RequestMapping(value = "/back")
@Api(tags = "后台相关")
@AllArgsConstructor
public class BackController {
    private final BackService backService;

    private final UserService userService;

    private final LoginService loginService;

    @PostMapping("/login")
    @ApiOperation("后台登录")
    public Response<String> backLogin(@Validated @RequestBody BackLoginRo ro) {
        return ResponseUtil.success(loginService.backLogin(ro));
    }


    @GetMapping("/user/page")
    @ApiOperation("用户列表")
    public Response<PageResult<UserPageVo>> page(PageQuery page, String keywords) {
        return ResponseUtil.success(userService.page(PageQuery.getPage(page), keywords));
    }

    @PostMapping("/user/add")
    @ApiOperation("添加用户")
    public Response<Boolean> add(@RequestBody @Validated AddUserRo ro) {
        return ResponseUtil.success(userService.add(ro));
    }

    @GetMapping("/user/deleteUser")
    @ApiOperation("删除用户")
    public Response<Boolean> delete(String id) {
        return ResponseUtil.success(userService.deleteUser(id));
    }


    @GetMapping("/feedback/page")
    @ApiOperation("查看反馈")
    public Response<PageResult<FeedBackVo>> feedbackPage(PageQuery page) {
        return ResponseUtil.success(backService.feedBackPage(PageQuery.getPage(page)));
    }


    @PostMapping("/coupon/add")
    @ApiOperation("添加优惠券")
    public Response<Boolean> addCoupon(@RequestBody AddOrUpdateCoupon ro) {
        return ResponseUtil.success(backService.addOrUpdateCoupon(ro));
    }

    @PostMapping("/coupon/page")
    @ApiOperation("后台优惠券列表")
    public Response<PageResult<CouponListVo.CouponVo>> backCouponBack(@RequestBody BackCouponRo ro) {
        return ResponseUtil.success(backService.backCouponPage(ro));
    }

    @GetMapping("/coupon/delete")
    @ApiOperation("删除优惠券")
    public Response<Boolean> deleteCoupon(String id) {
        return ResponseUtil.success(backService.deleteCoupon(id));
    }
}
