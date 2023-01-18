package com.boot.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dao.GoodsMapper;
import com.boot.dto.Goods;
import com.boot.service.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}
