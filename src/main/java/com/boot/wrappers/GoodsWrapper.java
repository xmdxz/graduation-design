package com.boot.wrappers;

import com.boot.dal.dao.Goods;
import com.boot.dto.vo.GoodsDetailVo;
import com.boot.dto.vo.GoodsPageVo;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class GoodsWrapper {
    public abstract List<GoodsPageVo> toPageVo(List<Goods> records);

    public abstract GoodsDetailVo toDetail(Goods goods);
}
