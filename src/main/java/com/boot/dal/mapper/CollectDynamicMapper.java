package com.boot.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.dal.dao.CollectDynamic;
import com.boot.dto.vo.CollectDynamicPageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author YuanXin
 * @ClassName CollectDynamicMapper
 * @Description TODO
 * @Date 2022/11/11 16:52
 */
@Mapper
public interface CollectDynamicMapper extends BaseMapper<CollectDynamic> {
    IPage<CollectDynamicPageVo> pageCollectByUserId(IPage<CollectDynamicPageVo> page, @Param("id") String id);
}