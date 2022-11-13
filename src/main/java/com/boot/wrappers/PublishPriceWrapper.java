package com.boot.wrappers;

import com.boot.dal.dao.PublishPrice;
import com.boot.dto.vo.PublishPriceVo;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/**
 * @Author YuanXin
 * @ClassName PublishPriceWrapper
 * @Description TODO
 * @Date 2022/11/13 11:45
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class PublishPriceWrapper {
    public abstract List<PublishPriceVo> toVo(List<PublishPrice> publishPrices);
}
