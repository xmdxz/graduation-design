package com.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dao.CouponMapper;
import com.boot.dto.Coupon;
import com.boot.service.CouponService;
import org.springframework.stereotype.Service;

/**
 * @class: CouponServiceImpl
 * @author: liyusheng
 * @description:
 * @date: 2023/1/14 23:51
 */
@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon> implements CouponService {
}
