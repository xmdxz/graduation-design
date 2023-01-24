package com.boot.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.dto.Goods;

public interface GoodsService extends IService<Goods> {

    /**
     *
     * @param userId 用户id
    	 * @param goodsId 商品id
     * @return boolean
     */
    public boolean buyGoods(String userId,String goodsId);
}
