package com.boot.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.common.util.SecurityUtil;
import com.boot.dal.dao.Chat;
import com.boot.dal.mapper.ChatMapper;
import com.boot.service.ChatService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shubo_Yang
 * @version 1.0
 * @date 2022/11/7 10:03
 */
@Service
public class ChatServiceImpl extends ServiceImpl<ChatMapper, Chat> implements ChatService {
    @Override
    public List<Chat> getChatList() {
        String userId = SecurityUtil.getUserId();
        return list(Wrappers.<Chat>lambdaQuery().eq(Chat::getUserId,userId).orderByDesc(Chat::getCreateTime));
    }
}
