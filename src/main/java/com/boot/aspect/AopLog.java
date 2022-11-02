package com.boot.aspect;

import com.boot.common.util.JsonTool;
import com.boot.common.util.SecurityUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: xuanzhangjiong
 * @Date: 2020/11/14 9:27 下午
 * @Email: xuanzhangjiong@induschain.cn
 */
@Aspect
@Component
@Slf4j
@AllArgsConstructor
public class AopLog {


    private static final String START_TIME = "request start：";

    /**
     * 切点
     */
    @Pointcut("execution(* com.boot.controller.*Controller.*(..)) ")
    public void log() {
    }

    /**
     * 前置操作
     *
     * @param point 切入点
     */
    @Before("log()")
    public void beforeLog(JoinPoint point) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        if (request.getHeader("x-forwarded-for") == null) {
            log.info("【请求 IP】：{}", request.getRemoteAddr());
        } else {
            log.info("【请求 IP】：{}", request.getHeader("x-forwarded-for"));
        }

        Map<String, String[]> parameterMap = request.getParameterMap();
        log.info(" [request mapping]:{},【请求参数】：{}", request.getRequestURL(), JsonTool.parse(parameterMap));
        Long start = System.currentTimeMillis();
        request.setAttribute(START_TIME, start);
    }

    /**
     * 环绕操作
     *
     * @param point 切入点
     * @return 原方法返回值
     * @throws Throwable 异常信息
     */
    @Around("log()")
    public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        Object result = point.proceed();
        log.info("【User】：{}", JsonTool.parse(SecurityUtil.getUser()));
        if (point.getSignature().getName().equals("mobileQuery")) {
            log.info("【返回值】：{}", "PDF二进制流");
        } else {
            Map hashMap = JsonTool.convert(JsonTool.parse(result), HashMap.class);
            log.info("[request mapping]:{},【返回结果】：{success: {}, retCode: {}, retMsg: {}}", request.getRequestURL(),
                    hashMap.get("success"), hashMap.get("code"), hashMap.get("message"));
        }
        SecurityUtil.clear();
        return result;
    }

    /**
     * 后置操作
     */
    @AfterReturning("log()")
    public void afterReturning() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        Long start = (Long) request.getAttribute(START_TIME);
        Long end = System.currentTimeMillis();
        log.info("[request mapping]:{}【请求耗时】：{}毫秒", request.getRequestURL(), end - start);
    }

    /**
     * 转换request 请求参数
     *
     * @param paramMap request获取的参数数组
     */
    public Map<String, String> convertMap(Map<String, String[]> paramMap) {
        Map<String, String> rtnMap = new HashMap<String, String>();
        for (String key : paramMap.keySet()) {
            rtnMap.put(key, paramMap.get(key)[0]);
        }
        return rtnMap;
    }
}
