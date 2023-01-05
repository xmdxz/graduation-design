package com.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.common.request.page.PageResult;
import com.boot.dto.*;


public interface UserService {

    UserBasicInformation getUserBasic(String userId);

    Boolean deleteUser(String id);

    Boolean update(UserBasicInformation info);

    UserDataVo getData(String userId);

    Integer clearCollect(String userId);

    Boolean feedback(FeedBackRo ro);

    Boolean deleteComment(String userId, String commentId);

    Boolean deleteCollect(String userId, String collectId);

    PageResult<MineOrderVo> orders(MineOrderRo ro);

    PageResult<MineCommentVo> comments(MineCommentRo ro);

    PageResult<MineCollectVo> collects(MineCollectRo ro);

    Boolean pay(String orderId);

    Boolean cancelOrder(String orderId);

    CouponListVo coupons(String userId);

    Boolean exchangeCoupon(String userId, String code);


    PageResult<UserPageVo> page(IPage<User> page, String keywords);

    Boolean add(AddUserRo ro);

}
