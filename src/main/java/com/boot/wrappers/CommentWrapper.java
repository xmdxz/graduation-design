package com.boot.wrappers;

import com.boot.dal.dao.Comment;
import com.boot.dto.vo.CommentVo;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/**
 * @Author YuanXin
 * @ClassName CommentWrapper
 * @Description TODO
 * @Date 2022/11/12 19:53
 */
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class CommentWrapper {
    public abstract List<CommentVo> toCommentListVo(List<Comment> comments);
}
