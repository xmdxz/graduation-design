package com.boot.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.boot.common.enums.FindType;
import com.boot.common.enums.Type;
import com.boot.common.exception.ServiceException;
import com.boot.common.request.page.PageResult;
import com.boot.dal.dao.*;
import com.boot.dal.repository.*;
import com.boot.dto.common.vo.UserBasicInformation;
import com.boot.dto.ro.PublishCommentRo;
import com.boot.dto.vo.*;
import com.boot.service.UserService;
import com.boot.wrappers.GoodsWrapper;
import com.boot.wrappers.UserWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * @Author YuanXin
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Date 2022/10/27 17:50
 */


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserWrapper userWrapper;

    private final GoodsWrapper goodsWrapper;

    private final CollectDynamicRepository collectDynamicRepository;


    private final OrderRepository orderRepository;

    private final DynamicRepository dynamicRepository;

    private final CollectRepository collectRepository;

    private final GoodsRepository goodsRepository;

    private final UserRepository userRepository;
    private final CommentRepository commentRepository;
    private final PublishPriceRepository publishPriceRepository;

    @Override
    public UserBasicInformation getUserBasic(String userId) {
        User user = Optional.ofNullable(userRepository.getById(userId)).orElseThrow(() -> new ServiceException("用户不存在"));
        return userWrapper.toBasic(user);
    }

    @Override
    public UserDataVo data(String userId) {
        return Optional.ofNullable(userRepository.getData(userId)).orElseThrow(() -> new ServiceException("用户不存在"));
    }

    @Override
    public PageResult<CollectPageVo> pageCollect(IPage<CollectPageVo> page, String userId) {
        UserBasicInformation userInfo = getUserBasic(userId);
        IPage<CollectPageVo> res = collectRepository.pageCollectByUserId(page, userInfo.getId());
        return PageResult.buildResult(res);
    }

    @Override
    public PageResult<GoodsPageVo> publishPage(IPage<Goods> page, String userId) {
        IPage<Goods> goodsIPage = goodsRepository.pageOwn(page, userId);
        List<GoodsPageVo> res = goodsWrapper.toPageVo(goodsIPage.getRecords());
        return PageResult.buildResult(goodsIPage.getTotal(), res);
    }

    @Override
    public PageResult<OrderGoodsPageVo> orderPage(IPage<OrderGoodsPageVo> page, String userId, FindType type) {
        IPage<OrderGoodsPageVo> res = orderRepository.pageOwn(page, userId, type);
        return PageResult.buildResult(res);
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
    public PageResult<CollectDynamicPageVo> dynamic(IPage<CollectDynamicPageVo> page, String userId) {
        UserBasicInformation userInfo = getUserBasic(userId);
        IPage<CollectDynamicPageVo> res = collectDynamicRepository.pageCollectByUserId(page, userInfo.getId());
        return PageResult.buildResult(res);
    }

    @Override
    public Boolean delete(String id, Type type) {
        switch (type) {
            case GOODS:
                goodsRepository.removeById(id);
                break;
            case ORDER:
                orderRepository.removeById(id);
                break;
            case DYNAMIC:
                dynamicRepository.removeById(id);
                break;
            default:
                throw new ServiceException("系统错误,请重试");
        }
        return true;
    }

    @Override
    public Boolean collect(String id, String userId) {
        UserBasicInformation userBasic = userRepository.getUserBasic(userId);
        Collect collect = new Collect();
        collect.setUserId(userBasic.getId());
        collect.setGoodsId(id);
        return collectRepository.save(collect);
    }

    @Override
    public Boolean cancelCollect(String id, String userId) {
        Collect dao = collectRepository.getOne(Wrappers.<Collect>lambdaQuery().eq(Collect::getGoodsId, id).eq(Collect::getUserId, userId));
        if (ObjectUtil.isNull(dao)) {
            return true;
        }
        return collectRepository.removeById(dao);
    }

    @Override
    public Boolean publishComment(PublishCommentRo ro) {
        UserBasicInformation userBasic = getUserBasic(ro.getUserId());
        Comment comment = new Comment();
        comment.setType(ro.getType());
        comment.setUserId(userBasic.getId());
        comment.setContent(ro.getContent());
        comment.setOtherId(ro.getId());
        return commentRepository.save(comment);
    }

    @Override
    public Boolean publishPirce(String goodsId, String userId, BigDecimal price) {
        UserBasicInformation userBasic = getUserBasic(userId);
        PublishPrice dao = new PublishPrice();
        dao.setPrice(price);
        dao.setUserId(userBasic.getId());
        dao.setGoodsId(goodsId);
        return publishPriceRepository.save(dao);
    }

    @Override
    public Boolean isCollect(String goodsId, String userId) {
        Collect dao = collectRepository.getOne(Wrappers.<Collect>lambdaQuery()
                .eq(Collect::getGoodsId, goodsId)
                .eq(Collect::getUserId, userId));
        return ObjectUtil.isNotNull(dao);
    }

    @Override
    public Boolean dyCollect(String id, String userId) {
        UserBasicInformation userBasic = userRepository.getUserBasic(userId);
        CollectDynamic collect = new CollectDynamic();
        collect.setUserId(userBasic.getId());
        collect.setDynamicId(id);
        return collectDynamicRepository.save(collect);
    }

    @Override
    public Boolean dyCancelCollect(String id, String userId) {
        CollectDynamic dao = collectDynamicRepository.getOne(Wrappers.<CollectDynamic>lambdaQuery().eq(CollectDynamic::getDynamicId, id).eq(CollectDynamic::getUserId, userId));
        if (ObjectUtil.isNull(dao)) {
            return true;
        }
        return collectDynamicRepository.removeById(dao);
    }
}

