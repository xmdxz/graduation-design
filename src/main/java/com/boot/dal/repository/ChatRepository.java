package com.boot.dal.repository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dal.dao.Chat;
import com.boot.dal.mapper.ChatMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChatRepository extends ServiceImpl<ChatMapper, Chat> {
    public List<Chat> chatList(String goodsId) {
        return baseMapper.selectList(Wrappers.<Chat>lambdaQuery().eq(Chat::getGoodsId, goodsId)
                .eq(Chat::getIsDeleted, "0"));
    }

    public List<Chat> chatByUser(String userId) {
        return baseMapper.selectList(Wrappers.<Chat>lambdaQuery().eq(Chat::getUserId, userId)
                .eq(Chat::getIsDeleted, "0").groupBy(Chat::getGoodsId));
    }
}
