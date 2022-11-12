package com.boot.dal.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dal.dao.CollectDynamic;
import com.boot.dal.mapper.CollectDynamicMapper;
import com.boot.dto.vo.CollectDynamicPageVo;
import org.springframework.stereotype.Service;

/**
 * @Author YuanXin
 * @ClassName CollectDynamicRepository
 * @Description TODO
 * @Date 2022/11/11 16:53
 */

@Service
public class CollectDynamicRepository extends ServiceImpl<CollectDynamicMapper, CollectDynamic> {
    public IPage<CollectDynamicPageVo> pageCollectByUserId(IPage<CollectDynamicPageVo> page, String id) {
        return baseMapper.pageCollectByUserId(page, id);
    }
}
