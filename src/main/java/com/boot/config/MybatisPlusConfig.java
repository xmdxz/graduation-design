package com.boot.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


/**
 * mybatis-plus的分页配置，固定模板配置
 */
@Configuration
public class MybatisPlusConfig {


    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // 注册分页插件
        interceptor.addInnerInterceptor(paginationInnerInterceptor());
        return interceptor;
    }

    @Bean
    public PaginationInnerInterceptor paginationInnerInterceptor() {
        PaginationInnerInterceptor interceptor = new PaginationInnerInterceptor();
        interceptor.setDbType(DbType.MYSQL);
        // 设置请求的页面大于最大页后操作,true调回首页,false继续请求 
        interceptor.setOverflow(false);
        // 设置最大单页限制数量,-1 不受限制
        interceptor.setMaxLimit(-1L);
        // 开启count的join优化,目前只针对left join有效
        interceptor.setOptimizeJoin(true);
        return interceptor;
    }

    /**
     * 插入更新等打印个日志
     */
    @Component
    public static class MybatisPlusMetaObjectHandler implements MetaObjectHandler {

        private static final Logger log = LoggerFactory.getLogger(MybatisPlusMetaObjectHandler.class);

        private static final String CREATE_TIME = "createTime";

        private static final String UPDATE_TIME = "updateTime";

        @Override
        public void insertFill(MetaObject metaObject) {
            log.info("start insert fill ...");
            Timestamp now = new Timestamp(System.currentTimeMillis());
            if (metaObject.hasSetter(CREATE_TIME)) {
                this.fillStrategy(metaObject, CREATE_TIME, now);
            }
            if (metaObject.hasSetter(UPDATE_TIME)) {
                this.fillStrategy(metaObject, UPDATE_TIME, now);
            }
        }

        @Override
        public void updateFill(MetaObject metaObject) {
            log.info("start update fill ...");
            Timestamp now = new Timestamp(System.currentTimeMillis());
            if (metaObject.hasSetter(UPDATE_TIME)) {
                this.strictUpdateFill(metaObject, UPDATE_TIME, Timestamp.class, now);
            }
        }
    }
}
