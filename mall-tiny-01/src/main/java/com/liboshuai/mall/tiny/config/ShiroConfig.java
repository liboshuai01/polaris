package com.liboshuai.mall.tiny.config;

import com.liboshuai.mall.tiny.shiro.UserRealm;
import com.liboshuai.mall.tiny.shiro.cache.CustomCacheManager;
import com.liboshuai.mall.tiny.shiro.jwt.JwtFilter;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.redis.core.RedisTemplate;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: liboshuai
 * @Date: 2022-09-09 17:41
 * @Description: shiro配置类
 */
@Slf4j
@Configuration
public class ShiroConfig {

    /**
     * 配置使用自定义Realm
     */
    @Bean("securityManager")
    public DefaultWebSecurityManager securityManager(UserRealm userRealm, RedisTemplate<String, Object> template) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 使用自定义Realm
        securityManager.setRealm(userRealm);
        // 关闭Shiro自带的session（因为我们采用的是Jwt token的机制）
        DefaultSubjectDAO defaultSubjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        defaultSubjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(defaultSubjectDAO);
        // 设置自定义Cache缓存
        securityManager.setCacheManager(new CustomCacheManager(template));
        return securityManager;
    }

    /**
     * 配置自定义过滤器
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        // 添加自己的过滤器名为jwtFilter
        Map<String, Filter> filterMap = new HashMap<>(16);
        filterMap.put("jwtFilter", jwtFilterBean());
        factoryBean.setFilters(filterMap);
        factoryBean.setSecurityManager(defaultWebSecurityManager);
        // 设置无权限时跳转的 url;
        factoryBean.setUnauthorizedUrl("/unauthorized/无权限");
        // 自定义url规则
        HashMap<String, String> filterRuleMap = new HashMap<>(16);
        // 所有请求通过我们自己的JwtFilter
        filterRuleMap.put("/**", "jwtFilter");
        factoryBean.setFilterChainDefinitionMap(filterRuleMap);
        return factoryBean;
    }

    /**
     * <pre>
     * 注入bean，此处应注意：
     *
     * (1)代码顺序，应放置于shiroFilter后面，否则报错：
     *
     * (2)如不在此注册，在filter中将无法正常注入bean
     * </pre>
     */
    @Bean("jwtFilter")
    public JwtFilter jwtFilterBean() {
        return new JwtFilter();
    }

    /**
     * 添加注解支持
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        // 强制使用cglib，防止重复代理和可能引起代理出错的问题，https://zhuanlan.zhihu.com/p/29161098
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * ||启动shiro的apo||
     * 使得我们后面加在方法上面的权限控制注解可以生效。
     * 例如：@RequiresPermissions("/sys/bank/delete"), @RequiresRoles("admin")
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
            DefaultWebSecurityManager defaultWebSecurityManager
    ) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(defaultWebSecurityManager);
        return advisor;
    }

}
