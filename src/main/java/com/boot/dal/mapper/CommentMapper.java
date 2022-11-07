package com.boot.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.dal.dao.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Shubo_Yang
 * @version 1.0
 * @date 2022/11/7 14:39
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
