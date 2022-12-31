package com.liboshuai.polaris.common.domain;

/**
 * @Author: liboshuai
 * @Date: 2022-07-10 22:46
 * @Description: 通用返回对象
 */
public class ResponseResult<T> {

    private long code;

    private String message;

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

    /**
     * 判断是否成功
     */
    public Boolean isSuccess() {
        return this.code == ResponseCode.SUCCESS.getCode();
    }
}
