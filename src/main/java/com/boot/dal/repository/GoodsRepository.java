package com.boot.dal.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dal.dao.Goods;
import com.boot.common.enums.GoodsStatus;
import com.boot.dal.mapper.GoodsMapper;
import org.springframework.stereotype.Service;

/**
 * @Author YuanXin
 * @ClassName GoodsRepository
 * @Description TODO
 * @Date 2022/11/9 17:20
 */

@Service
public class GoodsRepository extends ServiceImpl<GoodsMapper, Goods> {
    public IPage<Goods> pageOwn(IPage<Goods> page, String userId) {
        return baseMapper.pageOwn(page, userId);
    }
    public int soldGoods(String goodsId){
        return baseMapper.update(null, Wrappers.<Goods>lambdaUpdate()
                .set(Goods::getStatus,GoodsStatus.SOLD).eq(Goods::getId,goodsId));
    }
}
