package com.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.dto.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author YuanXin
 * @ClassName OrderMapper
 * @Description TODO
 * @Date 2022/12/21 17:54
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}