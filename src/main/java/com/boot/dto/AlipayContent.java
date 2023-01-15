package com.boot.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @class: AlipayContent
 * @author: liyusheng
 * @description:
 * @date: 2023/1/12 23:32
 */
@Data
@ApiModel("支付宝支付")
public class AlipayContent {
    @ApiModelProperty("订单号")
    private String outTradeNo;
    @ApiModelProperty("金额")
    private String totalAmount;
    @ApiModelProperty("支付网站标题")
    private String subject;
    @ApiModelProperty("产品代码")
    private String productCode;
    @ApiModelProperty("订单超时时间")
    private String timeoutExpress;
    @ApiModelProperty("支付中途退出返回商户网站地址")
    private String quitUrl;
}
