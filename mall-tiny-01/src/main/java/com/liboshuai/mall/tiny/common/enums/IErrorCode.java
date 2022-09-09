package com.liboshuai.mall.tiny.common.enums;

/**
 * @Author: liboshuai
 * @Date: 2022-07-10 22:26
 * @Deprecated: 封装API的错误码
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
