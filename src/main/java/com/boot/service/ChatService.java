package com.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.dal.dao.Chat;

import java.util.List;

/**
 * @author Shubo_Yang
 * @version 1.0
 * @date 2022/11/7 10:02
 */
public interface ChatService extends IService<Chat> {

    /**
     * 获取聊天列表
     * @return java.util.List<com.boot.dal.dao.Chat>
     * @author Shubo_Yang
     * @date 2022/11/7 10:04
     */
    public List<Chat> getChatList();

    /**
     * 插入新的聊天
     * @param chat 聊天内容
     * @return int
     * @author Shubo_Yang
     * @date 2022/11/7 10:13
     */
    public int insertNewChat(Chat chat);

    /**
     * 根据id删除聊天
     *
     * @param id 主键
     * @return int
     * @author Shubo_Yang
     * @date 2022/11/7 10:37
     */
    public int deleteChat(String id);
}
