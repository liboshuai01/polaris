package com.liboshuai.mall.tiny.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.liboshuai.mall.tiny.component.JwtAuthenticationTokenFilter;
import com.liboshuai.mall.tiny.component.RestAuthenticationEntryPoint;
import com.liboshuai.mall.tiny.component.RestfulAccessDeniedHandler;
import com.liboshuai.mall.tiny.domain.dao.UmsAdmin;
import com.liboshuai.mall.tiny.domain.dao.UmsPermission;
import com.liboshuai.mall.tiny.domain.dto.AdminUserDetails;
import com.liboshuai.mall.tiny.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-07-22 09:49
 * @Description: Spring Security配置类
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UmsAdminService umsAdminService;

    @Autowired
    private RestfulAccessDeniedHandler restfulAccessDeniedHandler;

    @Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf() // 由于使用的是JWT，我们这里不需要csrf
                .disable()
                .sessionManagement() // 基于token，所以不需要session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 允许对于该网站的静态资源的无授权访问
                .antMatchers(HttpMethod.GET,
                        "/",
                        "/*.html",
                        "/favicon.ico",
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.css",
                        "/**/*.js",
                        "/swagger-resources/**",
                        "/v2/api-docs/**"
                )
                .permitAll()
                // 对登录注册要允许匿名访问
                .antMatchers("/mall.tiny/ums-admin/login", "/mall.tiny/ums-admin/register")
                .permitAll()
                // 跨域请求会先进行一次options请求
                .antMatchers(HttpMethod.OPTIONS)
                .permitAll()
                //.antMatchers("/**") // 测试时全部运行访问
                //.permitAll()
                .anyRequest() // 除了上面的所有请求都需要进行鉴权认证
                .authenticated();
        // 禁用缓存
        http.headers().cacheControl();
        // 添加JWT filter
        http.addFilterBefore(jwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        // 添加自定义未授权和未登录结果返回
        http.exceptionHandling()
                .accessDeniedHandler(restfulAccessDeniedHandler)
                .authenticationEntryPoint(restAuthenticationEntryPoint);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        // 获取登录用户信息
        return username -> {
            LambdaQueryWrapper<UmsAdmin> umsAdminLambdaQueryWrapper = new LambdaQueryWrapper<>();
            umsAdminLambdaQueryWrapper.eq(UmsAdmin::getUsername, username);
            UmsAdmin umsAdmin = umsAdminService.getOne(umsAdminLambdaQueryWrapper);
            if (umsAdmin != null) {
                List<UmsPermission> permissionList = umsAdminService.findPermissions(umsAdmin.getId());
                return new AdminUserDetails(umsAdmin, permissionList);
            }
            throw new UsernameNotFoundException("用户名或者密码错误");
        };
    }

    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
