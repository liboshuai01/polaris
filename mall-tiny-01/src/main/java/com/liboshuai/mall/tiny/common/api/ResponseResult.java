package com.liboshuai.mall.tiny.common.api;

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

    public static <T> ResponseResult<T> success(T data, String message) {
        return new ResponseResult<>(ResponseCode.SUCCESS.getCode(), message, data);
    }

    public static <T> ResponseResult<T> failed(IErrorCode errorCode) {
        return new ResponseResult<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    public static <T> ResponseResult<T> failed(String message) {
        return new ResponseResult<>(ResponseCode.FAILED.getCode(), message, null);
    }

    public static <T> ResponseResult<T> failed() {
        return failed(ResponseCode.FAILED);
    }

    public static <T> ResponseResult<T> validateFailed() {
        return failed(ResponseCode.VALIDATE_FILED);
    }

    public static <T> ResponseResult<T> validateFailed(String message) {
        return new ResponseResult<>(ResponseCode.VALIDATE_FILED.getCode(), message, null);
    }

    public static <T> ResponseResult<T> unauthorized(T data) {
        return new ResponseResult<>(ResponseCode.UNAUTHORIZED.getCode(), ResponseCode.UNAUTHORIZED.getMessage(), data);
    }

    public static <T> ResponseResult<T> forbidden(T data) {
        return new ResponseResult<>(ResponseCode.FORBIDDEN.getCode(), ResponseCode.FORBIDDEN.getMessage(), data);
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
