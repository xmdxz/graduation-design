package com.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dao.ShowMapper;
import com.boot.dto.Show;
import com.boot.service.ShowService;
import org.springframework.stereotype.Service;

/**
 * @class: ShowServiceImpl
 * @author: liyusheng
 * @description:
 * @date: 2023/1/3 11:32
 */
@Service
public class ShowServiceImpl extends ServiceImpl<ShowMapper, Show> implements ShowService {
}
