package com.boot.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.common.enums.Type;
import com.boot.dal.dao.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author YuanXin
 * @ClassName CommentMapper
 * @Description TODO
 * @Date 2022/11/9 11:25
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    List<Comment> listById(@Param("id") String id, @Param("type") Type type);
}