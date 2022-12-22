package com.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.dto.MineOrderRo;
import com.boot.dto.MineOrderVo;
import com.boot.dto.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author YuanXin
 * @ClassName OrderMapper
 * @Description TODO
 * @Date 2022/12/21 17:54
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    IPage<MineOrderVo> getMineOrders(IPage<Object> page, @Param("ro") MineOrderRo ro);
}