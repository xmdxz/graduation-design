package com.boot.controller;

import cn.hutool.json.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.boot.common.response.Response;
import com.boot.common.response.ResponseUtil;
import com.boot.dto.AlipayContent;
import com.boot.dto.Order;
import com.boot.enums.OrderStatus;
import com.boot.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

    @PostMapping("submitOrder")
    @ApiOperation("提交订单")
    public Response<Order> submitOrder(@RequestBody Order order) {
        // 创建订单
        order.setStatus(OrderStatus.WAIT_PAYED);
        orderService.save(order);
        return ResponseUtil.success(order);
    }

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
        alipayTradeWapPayRequest.setBizContent(bizContent.toString());
        String form = null;
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
    public void receiveMessage() {
       
    }
}
