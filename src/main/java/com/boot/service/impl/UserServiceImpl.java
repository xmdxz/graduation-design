package com.boot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.boot.common.request.page.PageQuery;
import com.boot.common.request.page.PageResult;
import com.boot.dao.*;
import com.boot.dto.*;
import com.boot.enums.CouponStatus;
import com.boot.enums.OrderStatus;
import com.boot.enums.Type;
import com.boot.exception.ServiceException;
import com.boot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final CouponMapper couponMapper;

    private final CollectMapper collectMapper;

    private final CommentMapper commentMapper;

    private final FeedbackMapper feedbackMapper;
    private final OrderMapper orderMapper;

    @Override
    public UserBasicInformation getUserBasic(String userId) {
        User user = Optional.ofNullable(userRepository.getById(userId)).orElseThrow(() -> new ServiceException("用户不存在"));
        UserBasicInformation target = new UserBasicInformation();
        BeanUtil.copyProperties(user, target, false);
        return target;
    }

    @Override
    public Boolean deleteUser(String id) {
        return userRepository.removeById(id);
    }

    @Override
    public Boolean update(UserBasicInformation info) {
        String userId = info.getId();
        User user = Optional.ofNullable(userRepository.getById(userId)).orElseThrow(() -> new ServiceException("用户不存在"));
        user.setAvatar(info.getAvatar());
        user.setUsername(info.getUsername());
        user.setMark(info.getMark());
        user.setSex(info.getSex());
        return userRepository.updateById(user);
    }

    @Override
    public UserDataVo getData(String userId) {
        UserBasicInformation userBasic = getUserBasic(userId);
        UserDataVo result = new UserDataVo();
        result.setUserInfo(userBasic);
        Timestamp now = new Timestamp(System.currentTimeMillis());
        result.setCoupon(couponMapper.selectCount(Wrappers.<Coupon>lambdaQuery()
                .eq(Coupon::getUserId, userBasic.getId())
                .eq(Coupon::getStatus, CouponStatus.NORMAL)
                .le(Coupon::getStartTime, now)
                .ge(Coupon::getEndTime, now)).intValue());
        result.setCollect(collectMapper.selectCount(Wrappers.<Collect>lambdaQuery()
                .eq(Collect::getUserId, userBasic.getId())
                .eq(Collect::getType, Type.MOVIE)).intValue());
        result.setComment(commentMapper.selectCount(Wrappers.<Comment>lambdaQuery()
                .eq(Comment::getType, Type.MOVIE)
                .eq(Comment::getUserId, userBasic.getId())).intValue());
        return result;
    }

    @Override
    public Integer clearCollect(String userId) {
        UserBasicInformation userBasic = getUserBasic(userId);
        return collectMapper.delete(Wrappers.<Collect>lambdaQuery()
                .eq(Collect::getUserId, userBasic.getId()));
    }

    @Override
    public Boolean feedback(FeedBackRo ro) {
        UserBasicInformation userBasic = getUserBasic(ro.getUserId());
        Feedback feedback = new Feedback();
        feedback.setUserId(userBasic.getId());
        feedback.setContent(ro.getContent());
        feedbackMapper.insert(feedback);
        return true;
    }

    @Override
    public Boolean deleteComment(String userId, String commentId) {
        getUserBasic(userId);
        commentMapper.deleteById(commentId);
        return true;
    }

    @Override
    public Boolean deleteCollect(String userId, String collectId) {
        getUserBasic(userId);
        collectMapper.deleteById(collectId);
        return true;
    }

    @Override
    public PageResult<MineOrderVo> orders(MineOrderRo ro) {
        IPage<MineOrderVo> page = orderMapper.getMineOrders(PageQuery.getPage(ro.getPage()), ro);
        return PageResult.buildResult(page);
    }

    @Override
    public PageResult<MineCommentVo> comments(MineCommentRo ro) {
        UserBasicInformation userInfo = getUserBasic(ro.getUserId());
        IPage<MineCommentVo> page = commentMapper.getMineComment(PageQuery.getPage(ro.getPage()), ro);
        page.getRecords().forEach(e -> e.setUserInfo(userInfo));
        return PageResult.buildResult(page);
    }

    @Override
    public PageResult<MineCollectVo> collects(MineCollectRo ro) {
        IPage<MineCollectVo> page = collectMapper.getMineColleco(PageQuery.getPage(ro.getPage()), ro);
        return PageResult.buildResult(page);
    }

    @Override
    public Boolean pay(String orderId) {
        Order order = orderMapper.selectById(orderId);
        if (ObjectUtil.equal(order.getStatus(), OrderStatus.FINISHED)) {
            throw new ServiceException("订单已经支付");
        }
        order.setStatus(OrderStatus.FINISHED);
        orderMapper.updateById(order);
        return true;
    }

    @Override
    public Boolean cancelOrder(String orderId) {
        Order order = orderMapper.selectById(orderId);
        if (ObjectUtil.isNull(order)) {
            throw new ServiceException("订单已取消");
        }
        orderMapper.deleteById(order);
        return true;
    }

    @Override
    public CouponListVo coupons(String userId) {
        getUserBasic(userId);
        List<Coupon> coupons = couponMapper.selectList(Wrappers.<Coupon>lambdaQuery()
                .eq(Coupon::getUserId, userId)
                .orderByDesc(Coupon::getUpdateTime));
        List<Coupon> expiredUpdate = new ArrayList<>();
        List<CouponListVo.CouponVo> normal = new ArrayList<>();
        List<CouponListVo.CouponVo> other = new ArrayList<>();
        coupons.forEach(e -> {
            if (Boolean.TRUE.equals(e.isExpired()) && ObjectUtil.equal(e.getStatus(), CouponStatus.NORMAL)) {
                e.setStatus(CouponStatus.EXPIRED);
                expiredUpdate.add(e);
            }
            CouponListVo.CouponVo instead = new CouponListVo.CouponVo();
            BeanUtil.copyProperties(e, instead, "startTime", "endTime");
            instead.setStartTime(e.getStartTime().getTime());
            instead.setEndTime(e.getEndTime().getTime());
            if (ObjectUtil.equal(e.getStatus(), CouponStatus.NORMAL)) {
                normal.add(instead);
            } else {
                other.add(instead);
            }
        });
        if (CollUtil.isNotEmpty(expiredUpdate)) {
            expiredUpdate.forEach(couponMapper::updateById);
        }
        CouponListVo result = new CouponListVo();
        result.setNormal(normal);
        result.setOther(other);
        return result;
    }

    @Override
    public Boolean exchangeCoupon(String userId, String code) {
        Coupon coupon = couponMapper.selectById(code);
        if (ObjectUtil.isNull(coupon)) {
            throw new ServiceException("优惠券不存在");
        }
        if (Boolean.TRUE.equals(coupon.isExpired()) && ObjectUtil.equal(coupon.getStatus(), CouponStatus.NORMAL)) {
            coupon.setStatus(CouponStatus.EXPIRED);
            couponMapper.updateById(coupon);
        }
        if (StrUtil.isNotBlank(coupon.getUserId())) {
            throw new ServiceException("该优惠券已被兑换");
        }
        if (ObjectUtil.notEqual(coupon.getStatus(), CouponStatus.NORMAL)) {
            throw new ServiceException("该优惠券" + coupon.getStatus().getMark());
        }
        coupon.setUserId(userId);
        couponMapper.updateById(coupon);
        return true;
    }

    @Override
    public PageResult<UserPageVo> page(IPage<User> page, String keywords) {
        IPage<User> userPage = userRepository.page(page, Wrappers.<User>lambdaQuery()
                .like(CharSequenceUtil.isNotBlank(keywords), User::getPhone, keywords)
                .or(CharSequenceUtil.isNotBlank(keywords), wrappers -> {
                    wrappers.like(User::getUsername, keywords);
                })
                .orderByDesc(User::getCreateTime));
        List<UserPageVo> userPageVos = BeanUtil.copyToList(userPage.getRecords(), UserPageVo.class);
        return PageResult.buildResult(userPage.getTotal(), userPageVos);
    }

    @Override
    public Boolean add(AddUserRo ro) {
        User dao = userRepository.getByPhone(ro.getPhone());
        if (ObjectUtil.isNotNull(dao)) {
            throw new ServiceException("该手机号已存在");
        }
        User user = new User();
        user.setPassword(ro.getPassword());
        user.setPhone(ro.getPhone());
        user.setUsername(ro.getUsername());
        return userRepository.save(user);
    }
}

