package com.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.dto.Coupon;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author YuanXin
 * @ClassName CouponMapper
 * @Description TODO
 * @Date 2022/12/21 17:12
 */
@Mapper
public interface CouponMapper extends BaseMapper<Coupon> {
}