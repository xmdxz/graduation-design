package com.boot.dal.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.common.enums.Type;
import com.boot.dal.dao.Comment;
import com.boot.dal.mapper.CommentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author YuanXin
 * @ClassName CommentRepository
 * @Description TODO
 * @Date 2022/11/12 19:45
 */

@Service
public class CommentRepository extends ServiceImpl<CommentMapper, Comment> {

    public List<Comment> listById(String id, Type type) {
        return baseMapper.listById(id, type);
    }
}