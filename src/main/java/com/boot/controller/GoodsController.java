package com.boot.controller;

import com.boot.common.request.page.PageQuery;
import com.boot.common.request.page.PageResult;
import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.ro.PublishGoodsRo;
import com.boot.dto.vo.GoodsDetailVo;
import com.boot.dto.vo.GoodsPageVo;
import com.boot.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/goods")
@Api(tags = "商品相关")
@AllArgsConstructor
public class GoodsController {

    private final GoodsService goodsService;


    @GetMapping(value = "/page")
    @ApiOperation("首页获取商品")
    public Response<PageResult<GoodsPageVo>> page(PageQuery page, String keywords) {
        return ResponseUtil.success(goodsService.page(PageQuery.getPage(page), keywords));
    }

    @GetMapping(value = "/detail")
    @ApiOperation("商品详情")
    public Response<GoodsDetailVo> goodsDetail(String id) {
        return ResponseUtil.success(goodsService.detail(id));
    }

    @PostMapping("/publish")
    @ApiOperation("发布商品")
    public Response<Boolean> publish(@RequestBody @Validated PublishGoodsRo ro) {
        return ResponseUtil.success(goodsService.publish(ro));
    }

    @GetMapping("/delete")
    @ApiOperation("删除商品")
    public Response<Boolean> delete(String id) {
        return ResponseUtil.success(goodsService.delete(id));
    }

}
