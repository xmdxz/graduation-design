package com.boot.controller;

import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.SwiperVo;
import com.boot.service.SwiperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Response<List<SwiperVo>> getSwiperList() {
        return ResponseUtil.success(swiperService.selectSwiperList());
    }
}
