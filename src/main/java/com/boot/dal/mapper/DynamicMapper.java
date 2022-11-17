package com.boot.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.dal.dao.Dynamic;
import com.boot.dto.vo.DynamicPageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface DynamicMapper extends BaseMapper<Dynamic> {
    IPage<DynamicPageVo> listPage(IPage<DynamicPageVo> page, @Param("userId") String userId, @Param("keywords") String keywords);
}