package com.boot.wrappers;

import com.boot.dal.dao.Goods;
import com.boot.dto.vo.GoodsPageVo;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/**
 * @Author YuanXin
 * @ClassName GoodsWrapper
 * @Description TODO
 * @Date 2022/11/9 17:43
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class GoodsWrapper {
    public abstract List<GoodsPageVo> toPageVo(List<Goods> records);
}
