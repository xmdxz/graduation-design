package com.boot.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.dal.dao.Goods;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author YuanXin
 * @ClassName GoodsMapper
 * @Description TODO
 * @Date 2022/11/9 11:25
 */
@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
}