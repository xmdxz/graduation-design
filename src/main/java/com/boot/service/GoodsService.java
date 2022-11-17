package com.boot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.common.request.page.PageResult;
import com.boot.dal.dao.Goods;
import com.boot.dto.ro.PublishGoodsRo;
import com.boot.dto.vo.GoodsDetailVo;
import com.boot.dto.vo.GoodsPageVo;


public interface GoodsService {
    PageResult<GoodsPageVo> page(IPage<Goods> page, String keywords);

    GoodsDetailVo detail(String id);

    Boolean publish(PublishGoodsRo ro);

    Boolean delete(String id);
}
