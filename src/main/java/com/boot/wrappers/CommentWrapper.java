package com.boot.wrappers;

import com.boot.dal.dao.CarouselChart;
import com.boot.dal.dao.Comment;
import com.boot.dal.dao.Notice;
import com.boot.dto.vo.CarouselChartVo;
import com.boot.dto.vo.CommentVo;
import com.boot.dto.vo.NoticePageVo;
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

    public abstract List<NoticePageVo> toNoticePageVo(List<Notice> records);

    public abstract List<CarouselChartVo> toChartVo(List<CarouselChart> list);
}
