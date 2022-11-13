package com.boot.dal.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dal.dao.Dynamic;
import com.boot.dal.mapper.DynamicMapper;
import com.boot.dto.vo.DynamicPageVo;
import org.springframework.stereotype.Service;

/**
 * @Author YuanXin
 * @ClassName DynamicRepository
 * @Description TODO
 * @Date 2022/11/12 13:08
 */
@Service
public class DynamicRepository extends ServiceImpl<DynamicMapper, Dynamic> {
    public IPage<DynamicPageVo> listPage(IPage<DynamicPageVo> page, String userId) {
        return baseMapper.listPage(page, userId);
    }
}
