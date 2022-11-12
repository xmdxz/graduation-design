package com.boot.dal.repository;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dal.dao.Dynamic;
import com.boot.dal.mapper.DynamicMapper;
import org.springframework.stereotype.Service;

/**
 * @Author YuanXin
 * @ClassName DynamicRepository
 * @Description TODO
 * @Date 2022/11/12 13:08
 */
@Service
public class DynamicRepository extends ServiceImpl<DynamicMapper, Dynamic> {
}
