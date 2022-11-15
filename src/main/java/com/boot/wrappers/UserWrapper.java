package com.boot.wrappers;

import com.boot.dal.dao.User;
import com.boot.dto.common.vo.UserBasicInformation;
import com.boot.dto.vo.UserPageVo;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/**
 * @Author YuanXin
 * @ClassName UserWrapper
 * @Description TODO
 * @Date 2022/9/6 14:54
 */

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class UserWrapper {

    public abstract UserBasicInformation toBasic(User user);

    public abstract List<UserPageVo> toPage(List<User> records);
}
