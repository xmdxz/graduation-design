package com.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.dto.Feedback;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author YuanXin
 * @ClassName FeedbackMapper
 * @Description TODO
 * @Date 2022/12/21 17:42
 */
@Mapper
public interface FeedbackMapper extends BaseMapper<Feedback> {

}