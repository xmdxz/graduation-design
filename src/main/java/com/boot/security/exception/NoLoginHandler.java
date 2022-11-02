package com.boot.security.exception;

import com.boot.common.response.ResponseUtil;
import com.boot.common.response.ResultCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author YuanXin
 * @ClassName NoLoginHandler
 * @Description TODO
 * @Date 2022/9/8 15:00
 */

@Component
public class NoLoginHandler implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseUtil.outputResponse(response, ResponseUtil.error(ResultCode.UNAUTHENTICATED, "您未登录或登录失效"));
    }
}
