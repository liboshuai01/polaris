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

    @ApiModelProperty(value = "成功标志")
    private boolean success;

    @ApiModelProperty(value = "响应数据")
    private T result;

    @ApiModelProperty(value = "时间戳")
    private long timestamp = System.currentTimeMillis();


    protected ResponseResult() {

    }

    protected ResponseResult(long code, String message, boolean success, T result) {
        this.code = code;
        this.message = message;
        this.result = result;
        this.success = success;
    }

    public static <T> ResponseResult<T> success() {
        return new ResponseResult<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), true, null);
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), true, data);
    }

    public static <T> ResponseResult<T> success(String message) {
        return new ResponseResult<>(ResponseCode.SUCCESS.getCode(), message, true, null);
    }

    public static <T> ResponseResult<T> success(String message, T data) {
        return new ResponseResult<>(ResponseCode.SUCCESS.getCode(), message, true, data);
    }

    public static <T> ResponseResult<T> fail() {
        return fail(ResponseCode.FAILED);
    }

    public static <T> ResponseResult<T> fail(String message) {
        return new ResponseResult<>(ResponseCode.FAILED.getCode(), message, false, null);
    }

    public static <T> ResponseResult<T> fail(ResponseCode errorCode) {
        return new ResponseResult<>(errorCode.getCode(), errorCode.getMessage(), false, null);
    }

    public static <T> ResponseResult<T> fail(ResponseCode errorCode, String message) {
        return new ResponseResult<>(errorCode.getCode(), message, false, null);
    }

    public static <T> ResponseResult<T> fail(ResponseCode errorCode, String message, T data) {
        return new ResponseResult<>(errorCode.getCode(), message, false, data);
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

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
