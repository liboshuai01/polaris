package com.liboshuai.mall.tiny.module.ums.domain.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.tiny.common.base.BaseDAO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 后台用户表
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Data
@TableName("ums_admin")
@ApiModel(value = "UmsAdmin对象", description = "后台用户表")
public class UmsAdmin extends BaseDAO {

    private static final long serialVersionUID = -2518367268203067400L;

    /**
     * 用户名
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 盐
     */
    @TableField("salt")
    private String salt;

    /**
     * 加盐次数
     */
    @TableField("salt_count")
    private Integer saltCount;

    /**
     * 头像
     */
    @TableField("icon")
    private String icon;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 备注信息
     */
    @TableField("note")
    private String note;

    /**
     * 最后登录时间
     */
    @TableField("login_time")
    private LocalDateTime loginTime;

    /**
     * 帐号启用状态：0->禁用；1->启用
     */
    @TableField("status")
    private Integer status;


}




