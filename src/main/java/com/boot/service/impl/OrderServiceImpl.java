package com.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dao.OrderMapper;
import com.boot.dto.Order;
import com.boot.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @class: OrderServiceImpl
 * @author: liyusheng
 * @description:
 * @date: 2023/1/12 22:31
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
