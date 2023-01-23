package com.boot.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dao.VipMapper;
import com.boot.dto.Vip;
import com.boot.enums.VipSource;
import com.boot.service.VipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VipServiceImpl extends ServiceImpl<VipMapper, Vip> implements VipService {
    @Override
    public boolean registerVip(String userId, VipSource source) {
        List<Vip> vips = baseMapper.selectList(Wrappers.<Vip>lambdaQuery().eq(Vip::getUserId,userId));
        if (CollectionUtil.isNotEmpty(vips)){
            return false;
        }
        Vip vip = new Vip();
        vip.setInvited(0);
        vip.setIntegral(0);
        vip.setSource(source);
        vip.setUserId(userId);
        baseMapper.insert(vip);
        return true;
    }

    @Override
    public boolean addIntegral(String userId, Integer integral) {
        String sql = "`integral`=`integral`+"+integral.toString();
        return update(null,Wrappers.<Vip>lambdaUpdate().eq(Vip::getUserId,userId).setSql(sql));
    }
}
