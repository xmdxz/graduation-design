package com.boot.dal.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dal.dao.CarouselChart;
import com.boot.dal.mapper.CarouselChartMapper;
import org.springframework.stereotype.Service;


@Service
public class CarouselChartRepository extends ServiceImpl<CarouselChartMapper, CarouselChart> {
}
