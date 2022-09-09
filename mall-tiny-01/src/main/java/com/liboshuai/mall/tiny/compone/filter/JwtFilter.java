package com.liboshuai.mall.tiny.compone.filter;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.liboshuai.mall.tiny.common.enums.ResponseCode;
import com.liboshuai.mall.tiny.compone.exception.CustomException;
import com.liboshuai.mall.tiny.compone.response.ResponseResult;
import com.liboshuai.mall.tiny.shiro.JwtToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.util.AntPathMatcher;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: liboshuai
 * @Date: 2022-09-09 22:49
 * @Description: jwt过滤器
 */
@Slf4j
public class JwtFilter extends BasicHttpAuthenticationFilter {

    private final AntPathMatcher pathMatcher = new AntPathMatcher();

    /**
     * 登录认证
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        // 添加免登录接口
        if (secretFree(httpServletRequest)) {
            return true;
        }
        // 判断用户是否想要登入
        if (this.isLoginAttempt(request, response)) {
            try {
                // 进行Shiro的登录UserRealm
                this.executeLogin(request, response);
            } catch (Exception e) {
                // 认证出现异常，传递错误信息msg
                String msg = e.getMessage();
                // 获取应用异常(该Cause是导致抛出此throwable(异常)的throwable(异常))
                Throwable throwable = e.getCause();
                if (throwable != null && throwable instanceof SignatureVerificationException) {
                    // 该异常为JWT的AccessToken认证失败(Token或者密钥不正确)
                    msg = "token或者密钥不正确(" + throwable.getMessage() + ")";
                }else {
                    // 应用异常不为空
                    if (throwable != null) {
                        // 获取应用异常msg
                        msg = throwable.getMessage();
                    }
                }
                /*
                 * 错误两种处理方式 1. 将非法请求转发到/401的Controller处理，抛出自定义无权访问异常被全局捕捉再返回Response信息 2.
                 * 无需转发，直接返回Response信息 一般使用第二种(更方便)
                 */
                // 直接返回Response信息
                this.response401(request, response, msg);
                return false;
            }
        }
        return true;
    }

    /**
     * 添加免密登录路径
     */
    private boolean secretFree(HttpServletRequest httpServletRequest) {
        String[] anonUrl = {"/login", "/swagger-ui.html", "/doc.html",
                "/webjars/**", "/swagger-resources", "/v2/api-docs", "/swagger-resources/**", "/test"};
        boolean match = false;
        for (String u : anonUrl) {
            if (pathMatcher.match(u, httpServletRequest.getRequestURI())) {
                match = true;
            }
        }
        if (match) {
            return true;
        }
        return false;
    }

    /**
     * 这里我们详细说明下为什么重写 可以对比父类方法，只是将executeLogin方法调用去除了
     * 如果没有去除将会循环调用doGetAuthenticationInfo方法
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        this.sendChallenge(request, response);
        return false;
    }

    /**
     * 检测Header里面是否包含Authorization字段，有就进行Token登录认证授权
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        // 拿到当前Header中Authorization的AccessToken(Shiro中getAuthzHeader方法已经实现)
        // String requestURI = ((HttpServletRequest) request).getRequestURI();
        String token = this.getAuthzHeader(request);
        return token != null;
    }

    /**
     * 进行AccessToken登录认证授权
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        // 拿到当前Header中Authorization的AccessToken(Shiro中getAuthzHeader方法已经实现)
        JwtToken token = new JwtToken(this.getAuthzHeader(request));
        // 提交给UserRealm进行认证，如果错误他会抛出异常并被捕获
        this.getSubject(request, response).login(token);
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }

    /**
     * 无需转发，直接返回Response信息
     */
    private void response401(ServletRequest req, ServletResponse resp, String msg) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = httpServletResponse.getWriter();
            String data = JSONObject.toJSONString(ResponseResult.fail(ResponseCode.NOT_LOGIN_IN));
            out.append(data);
        } catch (IOException e) {
            throw new CustomException("直接返回Response信息出现IOException异常:" + e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 对跨域提供支持
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
        httpServletResponse.setHeader("Access-Control-Allow-Headers",
                httpServletRequest.getHeader("Access-Control-Request-Headers"));
        // 跨域时会首先发送一个OPTIONS请求，这里我们给OPTIONS请求直接返回正常状态
        if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }
        return super.preHandle(request, response);
    }
}
