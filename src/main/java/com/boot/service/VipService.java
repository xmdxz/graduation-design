package com.boot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.boot.dto.Vip;
import com.boot.enums.VipSource;


public interface VipService extends IService<Vip> {

    /**
     *
     * @param userId 用户id
	 * @param source 注册成为Vip
     * @return boolean
     */
    boolean registerVip(String userId, VipSource source);

    /**
     * 增加会员积分
     * @param userId 用户
	 * @param integral 积分
     * @return boolean
     */
    boolean addIntegral(String userId,Integer integral);

    /**
     * 检查并且扣减积分
     * @param userId
	 * @param integral
     * @return boolean
     */
    boolean checkAndReduce(String userId,Integer integral);
}
