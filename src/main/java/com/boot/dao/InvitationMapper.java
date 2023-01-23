package com.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.dto.Invitation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InvitationMapper extends BaseMapper<Invitation> {
}
