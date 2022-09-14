package com.liboshuai.mall.tiny.shiro;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.liboshuai.mall.tiny.common.constants.RedisConstant;
import com.liboshuai.mall.tiny.common.constants.ShiroConstant;
import com.liboshuai.mall.tiny.module.ums.domain.dto.UmsPermissionDTO;
import com.liboshuai.mall.tiny.module.ums.domain.dto.UmsRoleDTO;
import com.liboshuai.mall.tiny.module.ums.service.UmsAdminService;
import com.liboshuai.mall.tiny.module.ums.service.UmsPermissionService;
import com.liboshuai.mall.tiny.module.ums.service.UmsRoleService;
import com.liboshuai.mall.tiny.shiro.cache.RedisClient;
import com.liboshuai.mall.tiny.shiro.jwt.JwtToken;
import com.liboshuai.mall.tiny.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: liboshuai
 * @Date: 2022-09-08 01:17
 * @Description: 自定义shiroRealm
 */
@Slf4j
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private RedisClient redis;

    @Autowired
    private UmsAdminService umsAdminService;

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
        String username = JwtUtil.getClaim(principalCollection.toString(), ShiroConstant.ACCOUNT);
        // 根据用户名称获取角色名称集合
        List<UmsRoleDTO> umsRoleDTOList = umsRoleService.findRolesByUsername(username);
        Set<String> roleNameSet = umsRoleDTOList.stream().map(UmsRoleDTO::getName).collect(Collectors.toSet());
        // 根据角色id集合获取权限值集合
        List<Long> userIdList = umsRoleDTOList.stream().map(UmsRoleDTO::getId).collect(Collectors.toList());
        List<UmsPermissionDTO> permissionList =  umsPermissionService.findPermissionsByRoleIds(userIdList);
        Set<String> permissionValueSet = permissionList.stream().map(UmsPermissionDTO::getValue).collect(Collectors.toSet());
        // 将角色名称集合和权限值集合放入到shiro认证信息中
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roleNameSet);
        simpleAuthorizationInfo.setStringPermissions(permissionValueSet);
        return simpleAuthorizationInfo;
    }

    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取token信息
        String token = (String) authenticationToken.getCredentials();
        if (StringUtils.isBlank(token)) {
            throw new AuthenticationException(ShiroConstant.TOKEN_CANNOT_BE_EMPTY);
        }
        // 使用jwtUtil解密获取Username
        String username = JwtUtil.getClaim(token, ShiroConstant.ACCOUNT);
        if (StringUtils.isBlank(username)) {
            throw new AuthenticationException(ShiroConstant.TOKEN_INVALID);
        }
        Long userId = umsAdminService.findUserIdByUserName(username);
        if (Objects.isNull(userId)) {
            throw new AuthenticationException(ShiroConstant.USER_DIDNT_EXISTED);
        }
        // 开始认证，要AccessToken认证通过，且Redis中存在RefreshToken，且两个Token时间戳一致
        boolean verify = JwtUtil.verify(token);
        boolean b = redis.hasKey(RedisConstant.PREFIX_SHIRO_REFRESH_TOKEN + ShiroConstant.ACCOUNT);
        if (JwtUtil.verify(token) && redis.hasKey(RedisConstant.PREFIX_SHIRO_REFRESH_TOKEN + ShiroConstant.ACCOUNT)) {
            // 获取RefreshToken的时间戳
            String currentTimeMillisRedis = redis.get(RedisConstant.PREFIX_SHIRO_REFRESH_TOKEN + ShiroConstant.ACCOUNT).toString();
            // 获取AccessToken时间戳，与RefreshToken的时间戳对比
            String claim = JwtUtil.getClaim(token, ShiroConstant.CURRENT_TIME_MILLIS);
            if (Objects.equals(JwtUtil.getClaim(token, ShiroConstant.CURRENT_TIME_MILLIS), currentTimeMillisRedis)) {
                return new SimpleAuthenticationInfo(token, token, ShiroConstant.REALM_NAME);
            }
        }
        throw new AuthenticationException(ShiroConstant.TOKEN_EXPIRED_OR_INCORRECT);
    }
}
