package com.boot.dal.repository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dal.dao.Chat;
import com.boot.dal.mapper.ChatMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shubo_Yang
 * @version 1.0
 * @date 2022/11/12 15:04
 */
@Service
public class ChatRepository extends ServiceImpl<ChatMapper, Chat> {
    public List<Chat> chatList(String userId){
        return baseMapper.selectList(Wrappers.<Chat>lambdaQuery().eq(Chat::getUserId,userId)
                .eq(Chat::getIsDeleted,"0"));
    }
}
