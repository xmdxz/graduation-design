package com.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dao.CollectMapper;
import com.boot.dto.Collect;
import com.boot.service.CollectService;
import org.springframework.stereotype.Service;

/**
 * @class: CollectServiceImpl
 * @author: liyusheng
 * @description:
 * @date: 2023/1/11 21:38
 */
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {
}
