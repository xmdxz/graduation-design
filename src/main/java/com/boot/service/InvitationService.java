package com.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.dto.Goods;
import com.boot.dto.Invitation;

public interface InvitationService extends IService<Invitation> {

    /**
     *根据用户id获取邀请码
     * @param userId 用户id
     * @return com.boot.dto.Invitation
     * @date 2023/1/19 15:12
     */
    Invitation getInvitation(Goods goods, String userId);

    /**
     * 兑换邀请码
     *
     * @param userId 兑换用户id
	 * @param invitationCode 邀请码
     * @return boolean
     * @date 2023/1/19 15:39
     */
    boolean exchangeCode(String userId,String invitationCode);

}
