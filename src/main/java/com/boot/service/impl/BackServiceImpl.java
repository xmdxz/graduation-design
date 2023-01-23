package com.boot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.boot.common.request.page.PageQuery;
import com.boot.common.request.page.PageResult;
import com.boot.dao.CouponMapper;
import com.boot.dao.FeedbackMapper;
import com.boot.dao.UserMapper;
import com.boot.dto.*;
import com.boot.enums.CouponStatus;
import com.boot.service.BackService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author YuanXin
 * @ClassName BackServiceImpl
 * @Description TODO
 * @Date 2022/12/29 10:20
 */

@Service
@AllArgsConstructor
public class BackServiceImpl implements BackService {

    private final FeedbackMapper feedbackMapper;

    private final CouponMapper couponMapper;

    private final UserMapper userMapper;

    @Override
    public PageResult<FeedBackVo> feedBackPage(IPage<Object> page) {
        IPage<FeedBackVo> ipage = feedbackMapper.page(page);
        return PageResult.buildResult(ipage);
    }

    @Override
    public Boolean addOrUpdateCoupon(AddOrUpdateCoupon ro) {
        Coupon coupon = new Coupon();
        BeanUtil.copyProperties(ro, coupon);
        coupon.setStatus(CouponStatus.NORMAL);
        couponMapper.insert(coupon);
        return true;
    }

    @Override
    public PageResult<CouponListVo.CouponVo> backCouponPage(BackCouponRo ro) {
        IPage<Coupon> couponIPage = couponMapper.selectPage(PageQuery.getPage(ro.getPage()),
                Wrappers.<Coupon>lambdaQuery()
                        .like(Coupon::getName, ro.getName())
                        .orderByDesc(Coupon::getUpdateTime));
        List<Coupon> records = couponIPage.getRecords();
        if (CollUtil.isEmpty(records)) {
            return PageResult.buildResult(0L, new ArrayList<>());
        }
        Set<String> userIdSet = records.stream().map(Coupon::getUserId).filter(StrUtil::isNotBlank).collect(Collectors.toSet());
        Map<String, User> idUserMap = userMapper.selectBatchIds(userIdSet).stream().collect(Collectors.toMap(User::getId, e -> e));
        List<CouponListVo.CouponVo> result = new ArrayList<>();
        records.forEach(e -> {
            CouponListVo.CouponVo instead = new CouponListVo.CouponVo();
            BeanUtil.copyProperties(e, instead, "startTime", "endTime");
            instead.setStartTimeStr(e.getStartTime());
            instead.setEndTimeStr(e.getEndTime());
            User user = idUserMap.getOrDefault(e.getUserId(), new User());
            UserBasicInformation userInfo = new UserBasicInformation();
            BeanUtil.copyProperties(user, userInfo);
            instead.setUserInfo(userInfo);
            result.add(instead);
        });
        return PageResult.buildResult(couponIPage.getTotal(), result);
    }

    @Override
    public Boolean deleteCoupon(String id) {
        couponMapper.deleteById(id);
        return true;
    }
}
