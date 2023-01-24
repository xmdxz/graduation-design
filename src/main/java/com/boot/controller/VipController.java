package com.boot.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.Goods;
import com.boot.dto.Vip;
import com.boot.service.GoodsService;
import com.boot.service.InvitationService;
import com.boot.service.VipService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vip")
@Api(tags = "会员中心")
@AllArgsConstructor
public class VipController {

    private final VipService vipService;

    private final InvitationService invitationService;

    private final GoodsService goodsService;

    @GetMapping
    @ApiOperation("获取会员信息")
    public Response<Vip> getVipInfo(String userId){
        return ResponseUtil.success(vipService.getOne(Wrappers.<Vip>lambdaQuery().eq(Vip::getUserId,userId),false));
    }

    @GetMapping("/goods")
    @ApiOperation("获取会员商品")
    public Response<List<Goods>> getGoods(){
        return ResponseUtil.success(goodsService.list());
    }

    @PostMapping("/buyGoods")
    @ApiOperation("购买商品")
    public Response<Boolean> buyGoods(String userId,String goodsId){
        return ResponseUtil.success(goodsService.buyGoods(userId, goodsId));
    }

    @PostMapping("/useCode")
    @ApiOperation("使用兑换码")
    public Response useCode(String userId,String code){
        return ResponseUtil.result(invitationService.exchangeCode(userId, code));
    }

}
