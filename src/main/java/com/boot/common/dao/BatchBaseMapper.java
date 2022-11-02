package com.boot.common.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Author YuanXin
 * @ClassName BatchBaseMapper
 * @Description 主要用于解决mybatis-plus批量插入过慢的插件
 * @Date 2022/8/28 19:07
 */


public interface BatchBaseMapper<T> extends BaseMapper<T> {

    /**
     * 批量插入 仅适用于mysql
     *
     * @param entityList 实体列表
     * @return 影响行数
     */
    int insertBatchSomeColumn(List<T> entityList);
}
