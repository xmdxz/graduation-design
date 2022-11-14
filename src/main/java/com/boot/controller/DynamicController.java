package com.boot.controller;

import com.boot.common.request.page.PageQuery;
import com.boot.common.request.page.PageResult;
import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.ro.PublishDynamicRo;
import com.boot.dto.vo.DynamicPageVo;
import com.boot.service.DynamicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author YuanXin
 * @ClassName DynamicController
 * @Description TODO
 * @Date 2022/11/13 15:46
 */

@RestController
@AllArgsConstructor
@RequestMapping(value = "/dynamic")
@Api(tags = "动态相关")
public class DynamicController {

    private final DynamicService dynamicService;


    @PostMapping("/publish")
    @ApiOperation("发布动态")
    public Response<Boolean> publishDynamic(@RequestBody @Validated PublishDynamicRo ro) {
        return ResponseUtil.success(dynamicService.publish(ro));
    }

    @GetMapping("/page")
    @ApiOperation("分页获取")
    public Response<PageResult<DynamicPageVo>> page(PageQuery page, String userId, String keywords) {
        return ResponseUtil.success(dynamicService.page(PageQuery.getPage(page), userId, keywords));
    }

    @GetMapping("/delete")
    @ApiOperation("删除")
    public Response<Boolean> delete(String id) {
        return ResponseUtil.success(dynamicService.delete(id));
    }
}
