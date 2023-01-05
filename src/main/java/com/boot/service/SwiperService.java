package com.boot.service;

import com.boot.dto.SwiperVo;

import java.util.List;

/**
 * @interface: SwiperService
 * @author: liyusheng
 * @description:
 * @date: 2022/12/30 10:25
 */

public interface SwiperService {
   
    List<SwiperVo> selectSwiperList();
}
