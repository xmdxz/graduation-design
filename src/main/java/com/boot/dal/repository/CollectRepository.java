package com.boot.dal.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dal.dao.Collect;
import com.boot.dal.mapper.CollectMapper;
import com.boot.dto.vo.CollectPageVo;
import org.springframework.stereotype.Service;

/**
 * @Author YuanXin
 * @ClassName CollectRepository
 * @Description TODO
 * @Date 2022/11/9 16:55
 */

@Service
public class CollectRepository extends ServiceImpl<CollectMapper, Collect> {


    public IPage<CollectPageVo> pageCollectByUserId(IPage<CollectPageVo> page, String userId) {
        return baseMapper.pageCollectByUserId(page, userId);
    }
}
