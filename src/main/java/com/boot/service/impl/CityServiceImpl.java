package com.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dao.CityMapper;
import com.boot.dto.City;
import com.boot.service.CityService;
import org.springframework.stereotype.Service;

/**
 * @class: CityServiceImpl
 * @author: liyusheng
 * @description:
 * @date: 2022/12/28 14:06
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {
}
