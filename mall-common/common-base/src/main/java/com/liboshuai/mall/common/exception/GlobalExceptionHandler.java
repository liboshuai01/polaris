package com.liboshuai.mall.common.exception;


import com.liboshuai.mall.common.domain.ResponseResult;
import com.pig4cloud.plugin.idempotent.exception.IdempotentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

/**
 * @author baobao
 * @create 2021-09-09 22:31
 * @description 全局异常处理器
 */
@ConditionalOnWebApplication
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 自定义业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public ResponseResult<Void> handleCustomException(BusinessException e) {
        return ResponseResult.fail(e.getMessage());
    }

    /**
     * 数据重复异常
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseResult<Void> handleDuplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage(), e);
        return ResponseResult.fail("数据重复");
    }

    /**
     * 数据校验异常
     */
    @ExceptionHandler(BindException.class)
    public ResponseResult<Void> handleValidateException(BindException e) {
        log.error(e.getMessage(), e);
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return ResponseResult.fail(message);
    }

    /**
     * 数据校验异常
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseResult<Void> handleValidateException(ConstraintViolationException e) {
        log.error(e.getMessage(), e);
        String message = e.getConstraintViolations().iterator().next().getMessage();
        return ResponseResult.fail(message);
    }

    /**
     * 数据校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult<Void> handleValidateException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        return ResponseResult.fail(message);
    }

    /**
     * 参数非法异常
     * 重复提交异常
     */
    @ExceptionHandler({IllegalArgumentException.class, IdempotentException.class})
    public ResponseResult<Void> handleIllegalArgumentException(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseResult.fail(e.getMessage());
    }

    /**
     * 其余未知异常
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult<Void> handleOtherException(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseResult.fail("系统繁忙");
    }
}
