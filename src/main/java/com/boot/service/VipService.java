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
     * @date 2023/1/19 16:23
     */
    boolean registerVip(String userId, VipSource source);

    /**
     * 增加会员积分
     * @param userId 用户
	 * @param integral 积分
     * @return boolean
     * @author Shubo_Yang
     * @date 2023/1/19 16:35
     */
    boolean addIntegral(String userId,Integer integral);
}
