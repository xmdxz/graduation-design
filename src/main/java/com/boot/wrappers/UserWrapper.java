package com.boot.wrappers;

import com.boot.dal.dao.User;
import com.boot.dto.common.vo.UserBasicInformation;
import com.boot.dto.vo.UserPageVo;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class UserWrapper {

    public abstract UserBasicInformation toBasic(User user);

    public abstract List<UserPageVo> toPage(List<User> records);
}
