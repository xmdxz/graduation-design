package com.boot.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.boot.dal.dao.PublishPrice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author YuanXin
 * @ClassName PublishPriceMapper
 * @Description TODO
 * @Date 2022/11/13 11:37
 */
@Mapper
public interface PublishPriceMapper extends BaseMapper<PublishPrice> {
    List<PublishPrice> listById(@Param("id") String id);
}