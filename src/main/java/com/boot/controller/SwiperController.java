package com.boot.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.Swiper;
import com.boot.dto.SwiperVo;
import com.boot.service.SwiperService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @class: SwiperController
 * @author: liyusheng
 * @description:
 * @date: 2022/12/30 10:24
 */
@RestController
@RequestMapping("/swiper")
public class SwiperController {
    @Resource
    private SwiperService swiperService;

    @GetMapping("getSwiperList")
    @ApiOperation("获取所有轮播图")
    public Response<List<SwiperVo>> getSwiperList() {
        return ResponseUtil.success(swiperService.selectSwiperList());
    }


    @GetMapping("getSwiperListForManage")
    @ApiOperation("获取所有轮播图")
    public Response<List<SwiperVo>> getSwiperListForManage() {
        return ResponseUtil.success(swiperService.selectSwiperListForManage());
    }

    @PostMapping("addSwiper")
    @ApiOperation("添加轮播图")
    public Response<Boolean> addSwiper(@RequestBody Swiper swiper) {
        swiper.setIsDeleted(0);
        return ResponseUtil.success(swiperService.save(swiper));
    }

    @GetMapping("deleteSwiper")
    @ApiOperation("删除轮播图")
    public Response<Boolean> deleteSwiper(String id) {
        return ResponseUtil.success(swiperService.removeById(id));
    }

    @GetMapping("updateStatus")
    @ApiOperation("更新状态")
    public Response<Boolean> updateStatus(String id, Integer status) {
        LambdaUpdateWrapper<Swiper> swiperLambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        swiperLambdaUpdateWrapper.set(Swiper::getStatus, status)
                .eq(Swiper::getId, id);
        swiperService.update(swiperLambdaUpdateWrapper);
        return ResponseUtil.success(Boolean.TRUE);
    }
}
