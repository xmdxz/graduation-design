package com.boot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dao.VipMapper;
import com.boot.dto.Vip;
import com.boot.service.VIpService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VipServiceImpl extends ServiceImpl<VipMapper, Vip> implements VIpService {
}
