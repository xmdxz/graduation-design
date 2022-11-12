package com.boot.controller;

import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dal.dao.Chat;
import com.boot.service.ChatService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Shubo_Yang
 * @version 1.0
 * @date 2022/11/7 10:55
 */
@AllArgsConstructor
@RestController
@Api(tags = "聊天相关")
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    @GetMapping(value = "/chatList/{userId}")
    @ApiOperation("聊天列表")
    public Response<List<Chat>> chatList(@PathVariable String userId) {
        return ResponseUtil.success(chatService.getChatList(userId));
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("删除聊天")
    public Response<Boolean> deleteChat(@PathVariable String id) {
        return ResponseUtil.success(chatService.deleteChat(id));
    }

    @PostMapping
    @ApiOperation("插入聊天")
    public Response<Boolean> insertChat(@RequestBody  Chat chat){
        return ResponseUtil.success(chatService.insertNewChat(chat));
    }
}
