package com.boot.config;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConfig;
import com.alipay.api.DefaultAlipayClient;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @class: AlipayClientConfig
 * @author: liyusheng
 * @description:
 * @date: 2023/1/12 17:23
 */
@Configuration
@Log4j2
public class AlipayClientConfig {
    @Resource
    AlipayProperty alipayProperty;

    @Bean
    public AlipayClient alipayClient() {
        AlipayConfig alipayConfig = new AlipayConfig();
        alipayConfig.setServerUrl(alipayProperty.getUrl());
        alipayConfig.setAppId(alipayProperty.getAppid());
        alipayConfig.setAlipayPublicKey(alipayProperty.getAlipayPublicKey());
        alipayConfig.setFormat(alipayProperty.getFormat());
        alipayConfig.setPrivateKey(alipayProperty.getPrivateKey());
        alipayConfig.setCharset(alipayProperty.getCharset());
        alipayConfig.setSignType(alipayProperty.getSignType());
        DefaultAlipayClient defaultAlipayClient = null;
        try {
            defaultAlipayClient = new DefaultAlipayClient(alipayConfig);
        } catch (AlipayApiException e) {
            log.error("支付宝支付初始化异常:{}", e.getMessage(), e);
        }
        return defaultAlipayClient;
    }
}
