package com.boot.dal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.dal.dao.Collect;
import com.boot.dto.vo.CollectPageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author YuanXin
 * @ClassName CollectMapper
 * @Description TODO
 * @Date 2022/11/9 11:25
 */
@Mapper
public interface CollectMapper extends BaseMapper<Collect> {
    IPage<CollectPageVo> pageCollectByUserId(IPage<CollectPageVo> page, @Param("userId") String userId);
}