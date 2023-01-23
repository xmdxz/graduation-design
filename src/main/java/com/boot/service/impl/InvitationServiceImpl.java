package com.boot.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.boot.dao.InvitationMapper;
import com.boot.dto.Goods;
import com.boot.dto.Invitation;
import com.boot.dto.Vip;
import com.boot.enums.VipSource;
import com.boot.exception.ServiceException;
import com.boot.service.InvitationService;
import com.boot.service.VipService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InvitationServiceImpl extends ServiceImpl<InvitationMapper, Invitation> implements InvitationService {

    private final VipService vipService;

    @Override
    public Invitation getInvitation(Goods goods, String userId) {
        Vip vip = vipService.getOne(Wrappers.<Vip>lambdaQuery().eq(Vip::getUserId,userId),false);
        if (ObjectUtil.isNull(vip)){
            throw new ServiceException("您还不是会员，无法购买邀请码！");
        }
        Invitation invitation = baseMapper.selectOne(Wrappers.<Invitation>lambdaQuery().eq(Invitation::getUserId,userId));
        if (ObjectUtil.isNull(invitation)){
            if (VipSource.INVITATION.equals(vip.getSource())){
                throw new ServiceException("邀请会员无法购买邀请码！");
            }
            if (vip.getIntegral().compareTo(goods.getPrice())<0){
                throw new ServiceException("您的积分不足，无法购买邀请码！");
            }
            vip.setIntegral(vip.getIntegral() - goods.getPrice());
            vip.setInvited(1);
            invitation = createInvitation(vip);
            vipService.updateById(vip);
        }
        return invitation;
    }

    @Override
    public boolean exchangeCode(String userId, String invitationCode) {
        List<Invitation> invitations = baseMapper.selectList(Wrappers.<Invitation>lambdaQuery()
                .eq(Invitation::getInvitationCode,invitationCode));
        if (CollectionUtil.isEmpty(invitations)){
            throw new ServiceException("邀请码不存在！请检查");
        }
        Invitation invitation = invitations.get(0);
        if (StrUtil.isNotBlank(invitation.getInvitedUserId())){
            throw new ServiceException("邀请码已被使用");
        }
        invitation.setInvitedUserId(userId);
        baseMapper.updateById(invitation);
        vipService.registerVip(userId,VipSource.INVITATION);
        return true;
    }

    private Invitation createInvitation(Vip vip){
        Invitation invitation = new Invitation();
        invitation.setUserId(vip.getUserId());
        invitation.setInvitationCode(IdUtil.fastUUID());
        int i =baseMapper.insert(invitation);
        return invitation;
    }
}
