package com.liboshuai.mall.tiny.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: liboshuai
 * @Date: 2022-07-27 08:45
 * @Description: 后台权限类型枚举
 */
@Getter
@AllArgsConstructor
public enum UmsPermissionTypeEnum {

    /**
     * UmsPermission表的type字段，值为-1，意义为"减权限"
     */
    PERMISSION_TYPE_REDUCE(-1, "减权限"),

    /**
     * UmsPermission表的type字段，值为1，意义为“加权限”
     */
    PERMISSION_TYPE_PLUS(1, "加权限");

    private final Integer code;
    private final String message;
}
