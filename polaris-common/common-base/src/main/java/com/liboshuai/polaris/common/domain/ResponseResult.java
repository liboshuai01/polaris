package com.liboshuai.polaris.common.domain;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author: liboshuai
 * @Date: 2022-07-10 22:46
 * @Description: 通用响应结果对象
 */
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = -1036844242627722697L;

    @ApiModelProperty(value = "响应码")
    private long code;

    @ApiModelProperty(value = "响应信息")
    private String message;

    @ApiModelProperty(value = "响应数据")
    private T data;


    protected ResponseResult() {

    }

    protected ResponseResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseResult<T> success() {
        return new ResponseResult<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), null);
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }

    public static <T> ResponseResult<T> success(String message) {
        return new ResponseResult<>(ResponseCode.SUCCESS.getCode(), message, null);
    }

    public static <T> ResponseResult<T> success(String message, T data) {
        return new ResponseResult<>(ResponseCode.SUCCESS.getCode(), message, data);
    }

    public static <T> ResponseResult<T> success(long code, String message, T data) {
        return new ResponseResult<>(code, message, data);
    }

    public static <T> ResponseResult<T> fail() {
        return fail(ResponseCode.FAILED);
    }

    public static <T> ResponseResult<T> fail(String message) {
        return new ResponseResult<>(ResponseCode.FAILED.getCode(), message, null);
    }

    public static <T> ResponseResult<T> fail(ResponseCode errorCode) {
        return new ResponseResult<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static <T> ResponseResult<T> fail(ResponseCode errorCode, String message) {
        return new ResponseResult<>(errorCode.getCode(), message, null);
    }

    public static <T> ResponseResult<T> fail(ResponseCode errorCode, String message, T data) {
        return new ResponseResult<>(errorCode.getCode(), message, data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.code == 200;
    }
}
