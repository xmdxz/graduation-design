package com.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.dto.Comment;
import com.boot.dto.MineCommentRo;
import com.boot.dto.MineCommentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author YuanXin
 * @ClassName CommentMapper
 * @Description TODO
 * @Date 2022/12/21 17:12
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    IPage<MineCommentVo> getMineComment(IPage<Object> page, @Param("ro") MineCommentRo ro);
}