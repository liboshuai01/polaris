package com.liboshuai.mall.tiny.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: liboshuai
 * @Date: 2022-07-10 20:35
 * @Description: 请求返回码
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UmsAdminDTO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 头像
     */
    private String icon;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 昵称
     */
    private String nick_name;

    /**
     * 备注信息
     */
    private String note;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 最后登录时间
     */
    private String loginTime;

    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    private String status;
}
