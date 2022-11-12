package com.boot.controller;

import com.boot.common.enums.DeleteType;
import com.boot.common.enums.FindType;
import com.boot.common.request.page.PageQuery;
import com.boot.common.request.page.PageResult;
import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.common.vo.UserBasicInformation;
import com.boot.dto.vo.*;
import com.boot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public Response<Boolean> delete(String id, DeleteType type) {
        return ResponseUtil.success(userService.delete(id, type));
    }
}
