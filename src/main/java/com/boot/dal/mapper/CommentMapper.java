package com.boot.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.common.enums.Type;
import com.boot.dal.dao.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    List<Comment> listById(@Param("id") String id, @Param("type") Type type);
}