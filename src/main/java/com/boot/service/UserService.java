package com.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.common.enums.DeleteType;
import com.boot.common.enums.FindType;
import com.boot.common.request.page.PageResult;
import com.boot.dal.dao.Goods;
import com.boot.dto.common.vo.UserBasicInformation;
import com.boot.dto.vo.*;

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

    Boolean update(UserBasicInformation info);

    PageResult<CollectDynamicPageVo> dynamic(IPage<CollectDynamicPageVo> page, String userId);

    Boolean delete(String id, DeleteType type);
}
