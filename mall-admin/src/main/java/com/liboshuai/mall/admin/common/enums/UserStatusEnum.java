package com.liboshuai.mall.admin.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: liboshuai
 * @Date: 2022-09-11 00:01
 * @Description: 用户状态枚举
 */
@Getter
@AllArgsConstructor
public enum UserStatusEnum {

    /**
     * 禁用
     */
    DISABLE(0, "禁用"),

    /**
     * 启用
     */
    Enable(1, "启用");

    private final Integer code;
    private final String message;
}
