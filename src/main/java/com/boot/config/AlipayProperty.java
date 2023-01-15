package com.boot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @class: AlipyConfig
 * @author: liyusheng
 * @description:
 * @date: 2023/1/12 17:15
 */
@Component
@Data
@ConfigurationProperties(prefix = "alipy")
public class AlipayProperty {
    private String url;
    private String appid;
    private String privateKey;
    private String alipayPublicKey;
    private String signType;
    private String format;
    private String charset;
    private String notifyUrl;
}
