package com.liboshuai.mall.admin.compone.handler;

import com.liboshuai.mall.admin.common.enums.ResponseCode;
import com.liboshuai.mall.admin.compone.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author: liboshuai
 * @Date: 2022-09-10 00:34
 * @Description: 异常捕捉增强类
 */
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * 捕捉所有shiro异常
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public ResponseResult<?> handle401(ShiroException e) {
        return ResponseResult.fail(ResponseCode.UNAUTHORIZED, e.getMessage());
    }

    /**
     * 单独捕捉Shiro(UnauthorizedException)异常
     * 该异常为访问有权限管控的请求而该用户没有所需权限所抛出的异常
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseResult<?> handle401(UnauthorizedException e) {
        return ResponseResult.fail(ResponseCode.UNAUTHORIZED,
                "无权访问(Unauthorized):当前Subject没有此请求所需权限(" + e.getMessage() + ")");
    }

    /**
     * 单独捕捉Shiro(UnauthenticatedException)异常
     * 该异常为以游客身份访问有权限管控的请求无法对匿名主体进行授权，而授权失败所抛出的异常
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthenticatedException.class)
    public ResponseResult<?> handle401(UnauthenticatedException e) {
        return ResponseResult.fail(ResponseCode.UNAUTHORIZED,
                "无权访问(Unauthorized):当前Subject是匿名Subject，请先登录(This subject is anonymous.)");
    }

    /**
     * 获取效验错误信息
     */
    private Map<String, Object> getValidError(List<FieldError> fieldErrors) {
        Map<String, Object> map = new HashMap<>(16);
        List<String> errorList = new ArrayList<>();
        StringBuffer errorMsg = new StringBuffer("效验异常(ValidException):");
        for (FieldError error :
                fieldErrors) {
            errorList.add(error.getField() + "-" + error.getDefaultMessage());
            errorMsg.append(error.getField() + "-" + error.getDefaultMessage() + "-");
        }
        map.put("errorList", errorList);
        map.put("errorMsg", errorMsg);
        return map;
    }
}
