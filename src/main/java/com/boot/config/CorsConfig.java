package com.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
// 表明这是一个配置类，springboot会自动将其初始化
//实现的这个WebMvcConfigurer接口是用于配置web的相关配置
public class CorsConfig implements WebMvcConfigurer {


    /**
     * 这个方法用于解决前后端分离情况下的跨域问题，固定模板配置
     *
     * @return
     */
    @Bean // 该注解表明这是一个创建对象的方法，spring会自动调用
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addExposedHeader("*");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

}
