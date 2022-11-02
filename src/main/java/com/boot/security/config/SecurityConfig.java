package com.boot.security.config;

import cn.hutool.core.util.ObjectUtil;
import com.boot.security.exception.NoLoginHandler;
import com.boot.security.filter.JwtAuthenticationFilter;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.Resource;

/**
 * @Author YuanXin
 * @ClassName SecurityConfig
 * @Description TODO
 * @Date 2022/9/5 18:08
 */

@Configuration
@EnableWebSecurity
@Data
@ConfigurationProperties(prefix = "spring.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private NoLoginHandler noLoginHandler;

    private Boolean debug;

    private String[] white;

    @Resource
    private CorsFilter corsFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .debug(!ObjectUtil.isNull(debug) && debug)
        ;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().and()
                .headers().frameOptions().disable().and()
                .addFilterBefore(corsFilter, ChannelProcessingFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint(noLoginHandler).and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers(white).permitAll()
                .anyRequest().authenticated()
                .and()
                .apply(new SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
                    @Override
                    public void configure(HttpSecurity builder) throws Exception {
                        builder.addFilterBefore(new JwtAuthenticationFilter(authenticationManagerBean()), UsernamePasswordAuthenticationFilter.class);
                    }
                });
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
