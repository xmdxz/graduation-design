package com.boot.config;

import com.boot.common.util.JsonTool;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @Author YuanXin
 * @ClassName GlobalConfig
 * @Description TODO
 * @Date 2022/8/11 14:08
 */

@Configuration
public class GlobalConfig implements ApplicationRunner {


    @Bean(name = "responseParse")
    /**
     *  解决覆盖原生ObjectMapper的问题
     */
    @ConditionalOnBean(value = {ObjectMapper.class})
    public ObjectMapper responseParse() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }

    @Bean(name = "objectMapper")
    @ConditionalOnBean(value = {ObjectMapper.class})
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }
    
    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        JsonTool.setObjectMapper(objectMapper);
    }
}
