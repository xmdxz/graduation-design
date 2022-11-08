package com.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
//        String userId = SecurityUtil.getUserId();
//        return list(Wrappers.<Chat>lambdaQuery().eq(Chat::getUserId,userId).orderByDesc(Chat::getCreateTime));
        return null;
    }

    @Override
    public int insertNewChat(Chat chat) {
//        chat.setUserId(SecurityUtil.getUserId());
//        return baseMapper.insert(chat);
        return 0;
    }

    @Override
    public int deleteChat(String id) {
//        Chat oldChat = baseMapper.selectById(id);
//        if (ObjectUtil.isNull(oldChat)){
//            throw new ServiceException("所删除数据不存在，请刷新页面重试!");
//        }
//        try {
//            if (oldChat.getUserId().equals(SecurityUtil.getUserId())){
//                return baseMapper.deleteById(id);
//            }
//        }catch (Exception e){
//            throw new ServiceException("您没有权限删除该数据！");
//        }
        return 0;
    }

}
