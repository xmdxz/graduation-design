package com.boot.dal.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dal.dao.Order;
import com.boot.dal.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
 * @Author YuanXin
 * @ClassName OrderRepository
 * @Description TODO
 * @Date 2022/11/9 11:02
 */
@Service
public class OrderRepository extends ServiceImpl<OrderMapper, Order> {
}
