package com.boot.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.dal.dao.Notice;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author YuanXin
 * @ClassName NoticeMapper
 * @Description TODO
 * @Date 2022/11/14 16:35
 */
@Mapper
public interface NoticeMapper extends BaseMapper<Notice> {
}