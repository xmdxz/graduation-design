package com.boot.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dao.GoodsMapper;
import com.boot.dto.Coupon;
import com.boot.dto.Goods;
import com.boot.enums.CouponStatus;
import com.boot.exception.ServiceException;
import com.boot.service.CouponService;
import com.boot.service.GoodsService;
import com.boot.service.InvitationService;
import com.boot.service.VipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
@AllArgsConstructor
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    private final InvitationService invitationService;

    private final CouponService couponService;

    private final VipService vipService;

    @Override
    public boolean buyGoods(String userId, String goodsId) {
        Goods goods = baseMapper.selectById(goodsId);
        switch (goods.getType()){
            case INVITATIONCODE:
                invitationService.getInvitation(goods,userId);
                break;
            case COUPON:
                if (!vipService.checkAndReduce(userId,goods.getPrice())){
                    throw new ServiceException("您还不是会员或者会员积分不足！");
                }
                Coupon coupon = new Coupon();
                coupon.setUserId(userId);
                coupon.setAmount(goods.getAmount());
                coupon.setStatus(CouponStatus.NORMAL);
                coupon.setStartTime(new Timestamp(System.currentTimeMillis()));
                coupon.setEndTime(new Timestamp(System.currentTimeMillis()-1000*60*60*24*30));
                coupon.setMark(goods.getMark());
                coupon.setName(goods.getName());
                couponService.save(coupon);
                break;
            default:
                break;
        }
        return true;
    }
}
