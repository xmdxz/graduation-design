package com.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.common.request.page.PageResult;
import com.boot.dal.dao.Goods;
import com.boot.dto.ro.PublishGoodsRo;
import com.boot.dto.vo.GoodsDetailVo;
import com.boot.dto.vo.GoodsPageVo;

/**
 * @Author YuanXin
 * @ClassName GoodsService
 * @Description TODO
 * @Date 2022/11/12 16:00
 */
public interface GoodsService {
    PageResult<GoodsPageVo> page(IPage<Goods> page);

    GoodsDetailVo detail(String id);

    Boolean publish(PublishGoodsRo ro);
}
