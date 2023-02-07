package com.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dao.SwiperMapper;
import com.boot.dto.Swiper;
import com.boot.dto.SwiperVo;
import com.boot.service.SwiperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @class: SwiperServiceImpl
 * @author: liyusheng
 * @description:
 * @date: 2023/1/3 09:59
 */
@Service
public class SwiperServiceImpl extends ServiceImpl<SwiperMapper, Swiper> implements SwiperService {
    @Resource
    private SwiperMapper swiperMapper;

    @Override
    public List<SwiperVo> selectSwiperList() {
        return swiperMapper.querySwiperList();
    }

    @Override
    public List<SwiperVo> selectSwiperListForManage() {
        return swiperMapper.querySwiperListForManage();
    }
}
