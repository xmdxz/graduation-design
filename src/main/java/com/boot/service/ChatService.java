package com.boot.service;

import com.boot.dal.dao.Chat;
import com.boot.dal.dao.Order;
import com.boot.dto.vo.ChatVo;

import java.util.List;


public interface ChatService {

    /**
     * 获取聊天列表
     *
     * @return java.util.List<com.boot.dal.dao.Chat>
     * @date 2022/11/7 10:04
     */
    public List<Chat> getChatList(String userId);

    /**
     * 插入新的聊天
     *
     * @param chat 聊天内容
     * @return int
     * @date 2022/11/7 10:13
     */
    public Boolean insertNewChat(Chat chat);

    /**
     * 根据id删除聊天
     *
     * @param id 主键
     * @return int
     * @date 2022/11/7 10:37
     */
    public Boolean deleteChat(String id);

    public int buy(Order order);

    public List<ChatVo> getChatVoList(String userId);
}
