package com.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.common.request.page.PageResult;
import com.boot.dto.AddOrUpdateCoupon;
import com.boot.dto.BackCouponRo;
import com.boot.dto.CouponListVo;
import com.boot.dto.FeedBackVo;

/**
 * @Author YuanXin
 * @ClassName BackService
 * @Description TODO
 * @Date 2022/12/28 20:22
 */
public interface BackService {
    PageResult<FeedBackVo> feedBackPage(IPage<Object> page);

    Boolean addOrUpdateCoupon(AddOrUpdateCoupon ro);

    PageResult<CouponListVo.CouponVo> backCouponPage(BackCouponRo ro);

    Boolean deleteCoupon(String id);
}
