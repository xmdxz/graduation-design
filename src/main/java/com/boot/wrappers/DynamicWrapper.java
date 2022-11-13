package com.boot.wrappers;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * @Author YuanXin
 * @ClassName DynamicWrapper
 * @Description TODO
 * @Date 2022/11/13 15:55
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class DynamicWrapper {
}
