package com.boot.security.filter;

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.ObjectUtil;
import com.boot.common.enums.CacheKeyEnum;
import com.boot.common.util.RedisUtil;
import com.boot.dal.dao.User;
import com.boot.security.eneity.JwtConfig;
import com.boot.security.eneity.SysUser;
import com.boot.security.util.JwtUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author YuanXin
 * @ClassName JwtAuthenticationFilter
 * @Description TODO
 * @Date 2022/9/6 15:03
 */
@Log4j2
public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader(JwtConfig.header);
        if (CharSequenceUtil.isNotBlank(token)) {
            SysUser userDetails = RedisUtil.getObject(CacheKeyEnum.USER_INFO.create(token), SysUser.class);
            // TODO token刷新
            if (ObjectUtil.isNotNull(userDetails)) {
                User user = userDetails.getUser();
                Map<String, Object> verify = JwtUtil.verify(token, userDetails.getUsername(), user.getEndpoint(), userDetails.getPassword());
                Boolean isSuccess = (Boolean) verify.get("isSuccess");
                if (Boolean.TRUE.equals(isSuccess)) {
                    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        }
        chain.doFilter(request, response);
    }
}
