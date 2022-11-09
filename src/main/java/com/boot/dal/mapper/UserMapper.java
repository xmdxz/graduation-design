package com.boot.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.dal.dao.User;
import com.boot.dto.vo.UserDataVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author YuanXin
 * @ClassName UserMapper
 * @Description
 * @Date 2022/8/28 11:46
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    UserDataVo getData(@Param("userId") String userId);
}