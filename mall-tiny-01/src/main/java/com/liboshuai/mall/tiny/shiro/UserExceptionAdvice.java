package com.liboshuai.mall.tiny.shiro;

import com.liboshuai.mall.tiny.common.api.ResponseCode;
import com.liboshuai.mall.tiny.common.api.ResponseResult;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author: liboshuai
 * @Date: 2022-09-08 01:03
 * @Description: 用户未授权统一异常处理器
 */
@RestControllerAdvice
public class UserExceptionAdvice {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseResult<?> unAuthorizedExceptionHandler(UnauthorizedException e) {
        return ResponseResult.failed(ResponseCode.UNAUTHORIZED);
    }
}
