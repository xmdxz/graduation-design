package com.boot.controller;

import com.boot.common.request.page.PageResult;
import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.*;
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

    @GetMapping("/data")
    @ApiOperation("获取我的页统计信息")
    public Response<UserDataVo> getData(String userId) {
        return ResponseUtil.success(userService.getData(userId));
    }


    @GetMapping("/clear/collect")
    @ApiOperation("一键清空收藏")
    public Response<Integer> clearCollect(String userId) {
        return ResponseUtil.success(userService.clearCollect(userId));
    }

    @PostMapping("/feedback")
    @ApiOperation("用户反馈")
    public Response<Boolean> feedback(@RequestBody @Validated FeedBackRo ro) {
        return ResponseUtil.success(userService.feedback(ro));
    }


    @GetMapping("/delete/comment")
    @ApiOperation("删除评论")
    public Response<Boolean> deleteComment(String userId, String commentId) {
        return ResponseUtil.success(userService.deleteComment(userId, commentId));
    }

    @GetMapping("/delete/collect")
    @ApiOperation("删除收藏")
    public Response<Boolean> deleteCollect(String userId, String collectId) {
        return ResponseUtil.success(userService.deleteCollect(userId, collectId));
    }

    @PostMapping("/orders")
    @ApiOperation("获取订单")
    public Response<PageResult<MineOrderVo>> orders(@RequestBody MineOrderRo ro) {
        return ResponseUtil.success(userService.orders(ro));
    }

    @PostMapping("/comment")
    @ApiOperation("获取我的评论")
    public Response<PageResult<MineCommentVo>> comments(@RequestBody MineCommentRo ro) {
        return ResponseUtil.success(userService.comments(ro));
    }


    @PostMapping("/collect")
    @ApiOperation("获取我的收藏")
    public Response<PageResult<MineCollectVo>> collects(@RequestBody MineCollectRo ro) {
        return ResponseUtil.success(userService.collects(ro));
    }

    @GetMapping("/order/pay")
    @ApiOperation("未支付订单支付")
    public Response<Boolean> pay(String orderId) {
        return ResponseUtil.success(userService.pay(orderId));
    }

    @GetMapping("/order/cancel")
    @ApiOperation("取消订单")
    public Response<Boolean> orderCancel(String orderId) {
        return ResponseUtil.success(userService.cancelOrder(orderId));
    }

    @GetMapping("/coupon")
    @ApiOperation("获取优惠券")
    public Response<CouponListVo> coupons(String userId) {
        return ResponseUtil.success(userService.coupons(userId));
    }

    @GetMapping("/coupon/exchange")
    @ApiOperation("兑换优惠券")
    public Response<Boolean> exchangeCoupon(String userId, String code) {
        return ResponseUtil.success(userService.exchangeCoupon(userId, code));
    }
}
