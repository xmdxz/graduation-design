package com.boot.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.boot.dao.*;
import com.boot.dto.*;
import com.boot.enums.CouponStatus;
import com.boot.enums.Type;
import com.boot.exception.ServiceException;
import com.boot.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final CouponMapper couponMapper;

    private final CollectMapper collectMapper;

    private final CommentMapper commentMapper;

    private final FeedbackMapper feedbackMapper;

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
}

