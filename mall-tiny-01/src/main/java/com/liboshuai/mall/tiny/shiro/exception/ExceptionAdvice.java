package com.liboshuai.mall.tiny.shiro.exception;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.liboshuai.mall.tiny.common.enums.ResponseCode;
import com.liboshuai.mall.tiny.compone.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
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
     * 单独捕捉Shiro(UnauthenticatedException)异常
     * 该异常为以游客身份访问有权限管控的请求无法对匿名主体进行授权，而授权失败所抛出的异常
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthenticatedException.class)
    public ResponseResult<?> handle401(TokenExpiredException e) {
        return ResponseResult.fail(ResponseCode.UNAUTHORIZED,
                "无权访问(Unauthorized):当前Subject的令牌已过期-TokenExpiredException");
    }

//    /**
//     * 捕捉效验异常（BindException）
//     */
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(BindException.class)
//    public ResponseResult<Object> validException(BindException e) {
//        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
//        Map<String, Object> errorMap = this.getValidError(fieldErrors);
//        return ResponseResult.fail(ResponseCode.UNAUTHORIZED, errorMap.get("errorMsg").toString(), errorMap.get("errorList"));
//    }
//
//    /**
//     * 捕捉效验异常(MethodArgumentNotValidException)
//     */
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseResult<Object> validException(MethodArgumentNotValidException e) {
//        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
//        Map<String, Object> errorMap = this.getValidError(fieldErrors);
//        return ResponseResult.fail(ResponseCode.FAILED, errorMap.get("errorMsg").toString(), errorMap.get("errorList"));
//
//    }
//
//    /**
//     * 捕捉其他所有异常
//     */
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception.class)
//    public ResponseResult<?> globalException(Throwable ex) {
//        return ResponseResult.fail(ResponseCode.FAILED, ex.toString() + ex.getMessage());
//    }
//
//    /**
//     * 捕捉其他所有自定义异常
//     */
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(CustomException.class)
//    public ResponseResult<?> handle(CustomException e) {
//        return ResponseResult.fail(ResponseCode.FAILED, e.getMessage());
//    }

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

    /**
     * 获取状态码
     */
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
