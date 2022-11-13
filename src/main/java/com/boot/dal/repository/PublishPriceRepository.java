package com.boot.dal.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dal.dao.PublishPrice;
import com.boot.dal.mapper.PublishPriceMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author YuanXin
 * @ClassName PublishPriceRepository
 * @Description TODO
 * @Date 2022/11/13 11:38
 */
@Service
public class PublishPriceRepository extends ServiceImpl<PublishPriceMapper, PublishPrice> {
    public List<PublishPrice> listById(String id) {
        return baseMapper.listById(id);
    }
}
