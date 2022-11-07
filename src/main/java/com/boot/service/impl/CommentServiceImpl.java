package com.boot.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.common.dao.BaseTimeDeleteEntity;
import com.boot.common.enums.CommentTypeEnum;
import com.boot.common.util.SecurityUtil;
import com.boot.dal.dao.Comment;
import com.boot.dal.mapper.CommentMapper;
import com.boot.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Shubo_Yang
 * @version 1.0
 * @date 2022/11/7 14:43
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Override
    public List<Comment> selectComment(String pid) {
        return list(Wrappers.<Comment>lambdaQuery().eq(Comment::getPid,pid).orderByDesc(Comment::getCreateTime));
    }

    @Override
    public int insertGoodsComment(Comment comment) {
        comment.setType(CommentTypeEnum.GOODS.getCode());
        comment.setOtherId(SecurityUtil.getUserId());
        return save(comment)?1:0;
    }

    @Override
    public int insertDynamicComment(Comment comment) {
        comment.setType(CommentTypeEnum.DYNAMIC.getCode());
        comment.setOtherId(SecurityUtil.getUserId());
        return save(comment)?1:0;
    }
}
