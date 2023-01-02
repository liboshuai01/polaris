package com.liboshuai.polaris.common.enums;

import lombok.Getter;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 21:19
 * @Description:
 */
@Getter
public enum CommonStatusEnum {
    /**
     * 有效
     */
    VALID(1, "有效"),
    /**
     * 无效
     */
    INVALID(0, "无效")
    ;

    private final Integer statusCode;

    private final String statusMessage;

    CommonStatusEnum(Integer statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
