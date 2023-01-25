package com.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.dto.Swiper;
import com.boot.dto.SwiperVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author YuanXin
 * @ClassName SwiperMapper
 * @Description TODO
 * @Date 2022/12/22 10:32
 */
@Mapper
public interface SwiperMapper extends BaseMapper<Swiper> {

    List<SwiperVo> querySwiperList();

    List<SwiperVo> querySwiperListForManage();
}
