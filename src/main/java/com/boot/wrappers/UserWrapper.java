package com.boot.wrappers;

import com.boot.common.distance.LngLat;
import com.boot.common.util.LngLatUtil;
import com.boot.dal.dao.User;
import com.boot.dto.common.vo.UserBasicInformation;
import com.boot.security.eneity.SysUser;
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

    /**
     * 转换为Security的user
     *
     * @param user
     * @return
     */
    public abstract SysUser toSecurityUser(User user);

    public abstract UserBasicInformation toBasicUser(User user);


    public String getAddress(String lng, String lat) {
        LngLat lngLat = new LngLat(lng, lat);
        return LngLatUtil.getAddress(lngLat.getPosition());
    }
}
