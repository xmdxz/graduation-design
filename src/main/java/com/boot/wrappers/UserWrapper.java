package com.boot.wrappers;

import com.boot.dal.dao.User;
import com.boot.dto.common.vo.UserBasicInformation;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * @Author YuanXin
 * @ClassName UserWrapper
 * @Description TODO
 * @Date 2022/9/6 14:54
 */

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class UserWrapper {

    public abstract UserBasicInformation toBasic(User user);

}
