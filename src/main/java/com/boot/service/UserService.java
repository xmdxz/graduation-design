package com.boot.service;

import com.boot.dto.FeedBackRo;
import com.boot.dto.UserBasicInformation;
import com.boot.dto.UserDataVo;


public interface UserService {

    UserBasicInformation getUserBasic(String userId);

    Boolean deleteUser(String id);

    Boolean update(UserBasicInformation info);

    UserDataVo getData(String userId);

    Integer clearCollect(String userId);

    Boolean feedback(FeedBackRo ro);

    Boolean deleteComment(String userId, String commentId);

    Boolean deleteCollect(String userId, String collectId);
}
