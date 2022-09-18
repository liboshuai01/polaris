package com.liboshuai.mall.tiny.compone.exception;

/**
 * @Author: liboshuai
 * @Date: 2022-09-10 00:30
 * @Description: 自定义异常类
 */
public class CustomException extends RuntimeException {

    private static final long serialVersionUID = 781776451227176519L;

    public CustomException(String msg) {
        super(msg);
    }

    public CustomException() {
        super();
    }
}
