package com.boot.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.dal.dao.Chat;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ChatMapper extends BaseMapper<Chat> {
}
