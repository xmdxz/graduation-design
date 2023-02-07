package com.boot.controller;

import cn.hutool.json.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.config.AlipayProperty;
import com.boot.dto.AlipayContent;
import com.boot.dto.Order;
import com.boot.enums.OrderStatus;
import com.boot.enums.VipSource;
import com.boot.exception.ServiceException;
import com.boot.service.OrderService;
import com.boot.service.VipService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @class: PayController
 * @author: liyusheng
 * @description:
 * @date: 2023/1/12 17:50
 */
@RestController
@Api(tags = "支付")
@RequestMapping("pay")
public class PayController {
    @Resource
    AlipayClient alipayClient;

    @Resource
    OrderService orderService;

    @Resource
    VipService vipService;

    @Resource
    AlipayProperty alipayProperty;

    @GetMapping("payMoney")
    @ApiOperation("支付宝支付")
    public void payMoney(AlipayContent alipayContent, HttpServletResponse httpServletResponse) throws IOException {
        AlipayTradeWapPayRequest alipayTradeWapPayRequest = new AlipayTradeWapPayRequest();
        JSONObject bizContent = new JSONObject();
        bizContent.set("out_trade_no", alipayContent.getOutTradeNo());
        bizContent.set("total_amount", alipayContent.getTotalAmount());
        bizContent.set("subject", "手机网站支付");
        bizContent.set("product_code", "QUICK_WAP_WAY");
        bizContent.set("timeout_express", "30m");
        if (alipayContent.getOutTradeNo().contains("vip")){
            String userId = alipayContent.getOutTradeNo().substring(3);
            vipService.registerVip(userId, VipSource.PURCHASE);
        }
        alipayTradeWapPayRequest.setBizContent(bizContent.toString());
        alipayTradeWapPayRequest.setNotifyUrl(alipayProperty.getNotifyUrl());
        String form;
        try {
            form = alipayClient.pageExecute(alipayTradeWapPayRequest).getBody();
        } catch (AlipayApiException e) {
            throw new RuntimeException(e);
        }
        httpServletResponse.setContentType("text/html;charset=UTF-8");
        httpServletResponse.getWriter().write(form);
        httpServletResponse.getWriter().flush();
        httpServletResponse.getWriter().close();
    }

    @PostMapping("notify")
    @ApiOperation("接收支付宝通知")
    public void receiveMessage(HttpServletRequest request) {
        System.out.println("接收到通知");
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, String> param = new HashMap<>();
        for (String name : parameterMap.keySet()) {
            param.put(name, request.getParameter(name));
        }
        LambdaUpdateWrapper<Order> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.set(Order::getStatus, OrderStatus.FINISHED)
                .set(Order::getAlipayId, param.get("trade_no"))
                .eq(Order::getId, param.get("out_trade_no"));
        Order order = orderService.getById(param.get("out_trade_no"));
        vipService.addIntegral(order.getUserId(),Double.valueOf(String.valueOf(param.get("total_amount"))).intValue());
        orderService.update(updateWrapper);
    }

    @PostMapping("submitOrder")
    @ApiOperation("提交订单")
    public Response<Order> submitOrder(@RequestBody Order order) {
        order.setIsDeleted(0);
        Order one = orderService.getOne(Wrappers.lambdaQuery(Order.class).eq(Order::getMovieId, order.getMovieId()).eq(Order::getUserId, order.getUserId()));
        if (!Objects.isNull(one)) {
            throw new ServiceException("当前订单已创建");
        }
        order.setStatus(OrderStatus.WAIT_PAYED);
        try {
            orderService.save(order);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceException("提交订单异常");
        }
        return ResponseUtil.success(order);
    }
}
