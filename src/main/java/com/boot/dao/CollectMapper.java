package com.boot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.boot.dto.Collect;
import com.boot.dto.MineCollectRo;
import com.boot.dto.MineCollectVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author YuanXin
 * @ClassName CollectMapper
 * @Description TODO
 * @Date 2022/12/21 17:12
 */
@Mapper
public interface CollectMapper extends BaseMapper<Collect> {
    IPage<MineCollectVo> getMineColleco(IPage<Object> page, @Param("ro") MineCollectRo ro);
}