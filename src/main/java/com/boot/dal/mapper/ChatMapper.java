package com.boot.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.dal.dao.Chat;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Shubo_Yang
 * @version 1.0
 * @date 2022/11/7 9:59
 */
@Mapper
public interface ChatMapper extends BaseMapper<Chat> {
}
