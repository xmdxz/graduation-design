package com.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dal.dao.Chat;
import com.boot.dal.mapper.ChatMapper;
import com.boot.dal.repository.ChatRepository;
import com.boot.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shubo_Yang
 * @version 1.0
 * @date 2022/11/7 10:03
 */
@Service
@AllArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    @Override
    public List<Chat> getChatList(String userId) {
        return chatRepository.chatList(userId);
    }

    @Override
    public Boolean insertNewChat(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public Boolean deleteChat(String id) {
        return chatRepository.removeById(id);
    }

}
