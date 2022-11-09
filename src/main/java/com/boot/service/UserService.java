package com.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.common.enums.FindType;
import com.boot.common.request.page.PageResult;
import com.boot.dal.dao.Goods;
import com.boot.dto.common.vo.UserBasicInformation;
import com.boot.dto.vo.CollectPageVo;
import com.boot.dto.vo.GoodsPageVo;
import com.boot.dto.vo.OrderGoodsPageVo;
import com.boot.dto.vo.UserDataVo;

/**
 * @Author YuanXin
 * @ClassName UserService
 * @Description TODO
 * @Date 2022/10/27 17:49
 */
public interface UserService {

    UserBasicInformation getUserBasic(String userId);

    UserDataVo data(String userId);

    PageResult<CollectPageVo> pageCollect(IPage<CollectPageVo> page, String userId);

    PageResult<GoodsPageVo> publishPage(IPage<Goods> page, String userId);

    PageResult<OrderGoodsPageVo> orderPage(IPage<OrderGoodsPageVo> page, String userId, FindType type);
}
