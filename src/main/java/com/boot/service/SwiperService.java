package com.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.dto.Swiper;
import com.boot.dto.SwiperVo;

import java.util.List;

/**
 * @interface: SwiperService
 * @author: liyusheng
 * @description:
 * @date: 2022/12/30 10:25
 */

public interface SwiperService extends IService<Swiper> {

    List<SwiperVo> selectSwiperList();

    List<SwiperVo> selectSwiperListForManage();
}
