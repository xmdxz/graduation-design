package com.boot.service;

import com.boot.dto.UserBasicInformation;


public interface UserService {

    UserBasicInformation getUserBasic(String userId);

    Boolean deleteUser(String id);

    Boolean update(UserBasicInformation info);
}
