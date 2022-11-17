package com.boot.controller;

import com.boot.common.enums.FindType;
import com.boot.common.enums.Type;
import com.boot.common.request.page.PageQuery;
import com.boot.common.request.page.PageResult;
import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.common.vo.UserBasicInformation;
import com.boot.dto.ro.AddUserRo;
import com.boot.dto.ro.PublishCommentRo;
import com.boot.dto.vo.*;
import com.boot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RestController
@RequestMapping("/user")
@Api(tags = "个人中心")
@AllArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/page")
    @ApiOperation("用户列表")
    public Response<PageResult<UserPageVo>> page(PageQuery page, String keywords) {
        return ResponseUtil.success(userService.page(PageQuery.getPage(page), keywords));
    }

    @PostMapping("/add")
    @ApiOperation("添加用户")
    public Response<Boolean> add(@RequestBody @Validated AddUserRo ro) {
        return ResponseUtil.success(userService.add(ro));
    }

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
    @ApiOperation("获取我的页面的数据")
    public Response<UserDataVo> data(String userId) {
        return ResponseUtil.success(userService.data(userId));
    }

    @GetMapping("/collect")
    @ApiOperation("我的收藏")
    public Response<PageResult<CollectPageVo>> collectPageVo(PageQuery page, String userId) {
        return ResponseUtil.success(userService.pageCollect(PageQuery.getPage(page), userId));
    }

    @GetMapping("/publish")
    @ApiOperation("我发布的")
    public Response<PageResult<GoodsPageVo>> publishPage(PageQuery page, String userId) {
        return ResponseUtil.success(userService.publishPage(PageQuery.getPage(page), userId));
    }

    @GetMapping("/dynamic")
    @ApiOperation("收藏的帖子")
    public Response<PageResult<CollectDynamicPageVo>> dynamicPage(PageQuery page, String userId) {
        return ResponseUtil.success(userService.dynamic(PageQuery.getPage(page), userId));
    }

    @GetMapping("/order")
    @ApiOperation("我卖出的/我买入的")
    public Response<PageResult<OrderGoodsPageVo>> orderPage(PageQuery page, String userId, FindType type) {
        return ResponseUtil.success(userService.orderPage(PageQuery.getPage(page), userId, type));
    }

    @GetMapping("/delete")
    @ApiOperation("删除")
    public Response<Boolean> delete(String id, Type type) {
        return ResponseUtil.success(userService.delete(id, type));
    }

    @GetMapping("/save/collect")
    @ApiOperation("收藏")
    public Response<Boolean> collect(String id, String userId) {
        return ResponseUtil.success(userService.collect(id, userId));
    }


    @GetMapping("/cancel/collect")
    @ApiOperation("取消收藏")
    public Response<Boolean> cancelCollect(String id, String userId) {
        return ResponseUtil.success(userService.cancelCollect(id, userId));
    }

    @GetMapping("/save/dyCollect")
    @ApiOperation("收藏")
    public Response<Boolean> dyCollect(String id, String userId) {
        return ResponseUtil.success(userService.dyCollect(id, userId));
    }


    @GetMapping("/cancel/dyCollect")
    @ApiOperation("取消收藏")
    public Response<Boolean> dyCancelCollect(String id, String userId) {
        return ResponseUtil.success(userService.dyCancelCollect(id, userId));
    }

    @PostMapping("/comment")
    @ApiOperation("发表评论")
    public Response<Boolean> publishComment(@RequestBody @Validated PublishCommentRo ro) {
        return ResponseUtil.success(userService.publishComment(ro));
    }

    @GetMapping("/publishPrice")
    @ApiOperation("出价")
    public Response<Boolean> publishPrice(String goodsId, String userId, BigDecimal price) {
        return ResponseUtil.success(userService.publishPirce(goodsId, userId, price));
    }

    @GetMapping("/isCollect")
    @ApiOperation("查看是否收藏")
    public Response<Boolean> isCollect(String goodsId, String userId) {
        return ResponseUtil.success(userService.isCollect(goodsId, userId));
    }
}
