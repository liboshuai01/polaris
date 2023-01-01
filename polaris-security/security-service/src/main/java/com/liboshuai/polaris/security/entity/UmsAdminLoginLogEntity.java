package com.liboshuai.polaris.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.polaris.common.domain.BaseEntity;
import lombok.*;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 02:55
 * @Description: 后台用户登录日志表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("ums_admin_login_log")
public class UmsAdminLoginLogEntity extends BaseEntity {
    private static final long serialVersionUID = -4067703608777455089L;

    /**
     * 用户id
     */
    private Long adminId;

    /**
     * 用户登录所在ip地址
     */
    private String ip;

    /**
     * 用户登录所在地地址
     */
    private String address;

    /**
     * 浏览器登录类型
     */
    private String userAgent;
}
