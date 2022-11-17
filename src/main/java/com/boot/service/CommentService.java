package com.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.dal.dao.Comment;

import java.util.List;


public interface CommentService extends IService<Comment> {

    /**
     * 查询评论列表
     *
     * @param pid 父id
     * @return java.util.List<com.boot.dal.dao.Comment>
     * @author Shubo_Yang
     * @date 2022/11/7 14:46
     */
    public List<Comment> selectComment(String pid);

    /**
     * 插入商品评论
     *
     * @param comment
     * @return int
     * @author Shubo_Yang
     * @date 2022/11/7 14:54
     */
    public int insertGoodsComment(Comment comment);

    /**
     * 插入动态评论
     *
     * @param comment
     * @return int
     * @author Shubo_Yang
     * @date 2022/11/7 14:54
     */
    public int insertDynamicComment(Comment comment);
}
