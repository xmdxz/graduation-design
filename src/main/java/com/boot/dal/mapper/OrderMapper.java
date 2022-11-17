package com.boot.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.common.enums.FindType;
import com.boot.dal.dao.Order;
import com.boot.dto.vo.OrderGoodsPageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    IPage<OrderGoodsPageVo> pageOwn(IPage<OrderGoodsPageVo> page, @Param("userId") String userId, @Param("type") FindType type);
}