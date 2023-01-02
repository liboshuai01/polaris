package com.liboshuai.polaris.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.polaris.common.domain.BaseEntity;
import io.swagger.models.auth.In;
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
@TableName("sys_user")
public class SysUserEntity extends BaseEntity {

    private static final long serialVersionUID = -6448890637690328716L;

    /**
     * 登录账号
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 密码
     */
    private String password;

    /**
     * md5密码盐
     */
    private String salt;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 性别(0-默认未知,1-男,2-女)
     */
    private Integer sex;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 登录会话的机构编码
     */
    private String orgCode;

    /**
     * 性别(1-正常,2-冻结)
     */
    private Integer status;

    /**
     * 第三方登录的唯一标识
     */
    private String thirdId;

    /**
     * 第三方类型
     */
    private String thirdType;

    /**
     * 同步工作流引擎(1-同步,0-不同步)
     */
    private Integer activitiSync;

    /**
     * 工号，唯一键
     */
    private String workNo;

    /**
     * 职务，关联职务表
     */
    private String post;

    /**
     * 座机号
     */
    private String telephone;

    /**
     * 身份（1普通成员 2上级）
     */
    private Integer userIdentity;

    /**
     * 负责部门
     */
    private String departIds;

    /**
     * 设备ID
     */
    private String clientId;

}
