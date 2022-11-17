package com.boot.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.dal.dao.PublishPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface PublishPriceMapper extends BaseMapper<PublishPrice> {
    List<PublishPrice> listById(@Param("id") String id);
}