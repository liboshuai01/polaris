package com.liboshuai.polaris.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.polaris.common.domain.BaseEntity;
import lombok.*;

import java.util.Date;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 02:32
 * @Description: 后台用户表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("ums_admin")
public class UmsAdminEntity extends BaseEntity {

    private static final long serialVersionUID = -6448890637690328716L;

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
    private String nickName;

    /**
     * 备注信息
     */
    private String note;

    /**
     * 最后登录时间
     */
    private Date loginTime;

    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    private Integer status;
}
