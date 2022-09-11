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
    UNAUTHORIZED(401, "暂未登录"),
    NOT_LOGIN_IN(401, "账号未登录"),
    USERNAME_PASSWORD_NULL(401, "用户名或密码为空"),
    INCORRECT_CREDENTIALS(401, "账号或密码错误"),
    TOKEN_EXPIRE_OR_ERROR(401, "token不正确或过期"),
    SALT_IS_NOT_EXISTED(401,"盐或加盐数为空"),
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
