package com.liboshuai.mall.tiny.common.enums;

/**
 * @Author: liboshuai
 * @Date: 2022-07-10 20:35
 * @Description: 请求返回码
 */
@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
public enum ResponseCode{
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    NOT_LOGIN_IN(401, "账号未登录"),
    FORBIDDEN(403, "没有相关权限");


    private long code;

    private String message;

    ResponseCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
