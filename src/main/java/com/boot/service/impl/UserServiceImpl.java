package com.boot.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.common.enums.FindType;
import com.boot.common.exception.ServiceException;
import com.boot.common.request.page.PageResult;
import com.boot.dal.dao.Goods;
import com.boot.dal.dao.User;
import com.boot.dal.repository.CollectRepository;
import com.boot.dal.repository.GoodsRepository;
import com.boot.dal.repository.OrderRepository;
import com.boot.dal.repository.UserRepository;
import com.boot.dto.common.vo.UserBasicInformation;
import com.boot.dto.vo.CollectPageVo;
import com.boot.dto.vo.GoodsPageVo;
import com.boot.dto.vo.OrderGoodsPageVo;
import com.boot.dto.vo.UserDataVo;
import com.boot.service.UserService;
import com.boot.wrappers.GoodsWrapper;
import com.boot.wrappers.UserWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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


    private final OrderRepository orderRepository;

    private final CollectRepository collectRepository;

    private final GoodsRepository goodsRepository;

    private final UserRepository userRepository;

    @Override
    public UserBasicInformation getUserBasic(String userId) {
        User user = Optional.ofNullable(userRepository.getById(userId)).orElseThrow(() -> new ServiceException("用户不存在"));
        return userWrapper.toBasic(user);
    }

    @Override
    public UserDataVo data(String userId) {
        return userRepository.getData(userId);
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
}
