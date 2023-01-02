package com.liboshuai.polaris.security.service;

import com.liboshuai.polaris.common.domain.ResponseResult;
import com.liboshuai.polaris.security.query.LoginQuery;
import com.liboshuai.polaris.security.vo.SysUserInfoVO;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 19:49
 * @Description:
 */
public interface LoginService {
    /**
     * 用户登录
     */
    ResponseResult<SysUserInfoVO> login(LoginQuery loginQuery);
}
