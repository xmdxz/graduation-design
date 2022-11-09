package com.boot.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.dal.dao.Order;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author YuanXin
 * @ClassName OrderMapper
 * @Description TODO
 * @Date 2022/11/9 10:59
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}