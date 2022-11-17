package com.boot.service.impl;

import com.boot.common.enums.OrderStatus;
import com.boot.common.exception.ServiceException;
import com.boot.dal.dao.Chat;
import com.boot.dal.dao.Goods;
import com.boot.dal.dao.Order;
import com.boot.dal.dao.User;
import com.boot.dal.repository.ChatRepository;
import com.boot.dal.repository.GoodsRepository;
import com.boot.dal.repository.OrderRepository;
import com.boot.dal.repository.UserRepository;
import com.boot.dto.common.vo.UserBasicInformation;
import com.boot.dto.vo.ChatVo;
import com.boot.service.ChatService;
import com.boot.wrappers.UserWrapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ChatServiceImpl implements ChatService {

    private final UserWrapper userWrapper;

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;
    private final GoodsRepository goodsRepository;
    private final OrderRepository orderRepository;

    @Override
    public List<Chat> getChatList(String goodsId) {

        List<Chat> chatList = chatRepository.chatList(goodsId);
        chatList.forEach(e -> {
            User user = Optional.ofNullable(userRepository.getById(e.getUserId()))
                    .orElseThrow(() -> new ServiceException("用户不存在"));
            UserBasicInformation userInfo = userWrapper.toBasic(user);
            e.setUserInfo(userInfo);
        });
        return chatList;
    }

    @Override
    public Boolean insertNewChat(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    public Boolean deleteChat(String id) {
        return chatRepository.removeById(id);
    }

    @Override
    public int buy(Order order) {
        order.setStatus(OrderStatus.FINISHED);
        Goods goods = goodsRepository.getById(order.getGoodsId());
        order.setGoodsUserId(goods.getUserId());
        order.setAmount(goods.getPrice());
        orderRepository.save(order);
        return goodsRepository.soldGoods(order.getGoodsId());
    }

    @Override
    public List<ChatVo> getChatVoList(String userId) {
        List<Chat> chatList = chatRepository.chatByUser(userId);
        List<ChatVo> res = new ArrayList<>();
        for (Chat chat : chatList) {
            Goods goods = goodsRepository.getById(chat.getGoodsId());
            ChatVo vo = new ChatVo();
            vo.setName(goods.getName());
            vo.setImages(goods.getImages());
            vo.setContent(chat.getContent());
            vo.setGoodsId(chat.getGoodsId());
            res.add(vo);
        }

        return res;
    }


}
