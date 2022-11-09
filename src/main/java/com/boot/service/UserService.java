package com.boot.service;

import com.boot.dto.common.vo.UserBasicInformation;
import com.boot.dto.vo.UserDataVo;

/**
 * @Author YuanXin
 * @ClassName UserService
 * @Description TODO
 * @Date 2022/10/27 17:49
 */
public interface UserService {

    UserBasicInformation getUserBasic(String userId);

    UserDataVo data(String userId);
}
