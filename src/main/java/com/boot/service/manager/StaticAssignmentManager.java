package com.boot.service.manager;

import com.boot.common.util.LngLatUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author YuanXin
 * @ClassName StaticAssignmentManager
 * @Description TODO
 * @Date 2022/9/25 10:32
 */

@Component
public class StaticAssignmentManager implements ApplicationRunner {

    @Resource
    private ObjectMapper responseParse;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        LngLatUtil.setPARSE(responseParse);
    }
}
