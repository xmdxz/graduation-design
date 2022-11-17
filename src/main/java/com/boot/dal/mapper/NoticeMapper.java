package com.boot.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.dal.dao.Notice;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {
}