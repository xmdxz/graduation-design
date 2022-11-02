package com.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @ClassName MainStart
 * @Description 启动类
 * @Author YuanXin
 * @Date 2022/8/2 15:44
 */

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "com.boot.dal.mapper")
public class BootStarter {
    public static void main(String[] args) {
        SpringApplication.run(BootStarter.class, args);
    }
}
