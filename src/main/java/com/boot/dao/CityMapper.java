package com.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.dto.City;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author YuanXin
 * @ClassName CityMapper
 * @Description TODO
 * @Date 2022/12/22 10:32
 */
@Mapper
public interface CityMapper extends BaseMapper<City> {
}