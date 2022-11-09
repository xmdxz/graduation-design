package com.boot.dal.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.common.enums.FindType;
import com.boot.dal.dao.Order;
import com.boot.dal.mapper.OrderMapper;
import com.boot.dto.vo.OrderGoodsPageVo;
import org.springframework.stereotype.Service;

/**
 * @Author YuanXin
 * @ClassName OrderRepository
 * @Description TODO
 * @Date 2022/11/9 11:02
 */
@Service
public class OrderRepository extends ServiceImpl<OrderMapper, Order> {
    public IPage<OrderGoodsPageVo> pageOwn(IPage<OrderGoodsPageVo> page, String userId, FindType type) {
        return baseMapper.pageOwn(page, userId, type);
    }
}
