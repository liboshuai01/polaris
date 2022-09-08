package com.liboshuai.mall.tiny.shiro;

import com.liboshuai.mall.tiny.module.ums.service.UmsPermissionService;
import com.liboshuai.mall.tiny.module.ums.service.UmsRoleService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: liboshuai
 * @Date: 2022-09-08 01:17
 * @Description: 自定义shiroRealm
 */
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UmsRoleService umsRoleService;

    @Autowired
    private UmsPermissionService umsPermissionService;


    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }


    /**
     * 授权认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 从token中获取username

        // 根据用户名称获取角色信息集合

        // 根据角色id集合获取权限信息集合

        // 将角色信息和权限信息放入到shiro认证信息中

        return null;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
