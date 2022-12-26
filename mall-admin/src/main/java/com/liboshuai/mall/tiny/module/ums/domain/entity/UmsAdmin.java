package com.liboshuai.mall.tiny.module.ums.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.tiny.common.base.BaseEntity;
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
 * @since 2022-09-16
 */
@Data
@TableName("ums_admin")
@ApiModel(value = "UmsAdmin对象", description = "后台用户表")
public class UmsAdmin extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @ApiModelProperty("盐")
    @TableField("salt")
    private String salt;

    @ApiModelProperty("散列遍历次数")
    @TableField("salt_count")
    private Integer saltCount;

    @ApiModelProperty("头像")
    @TableField("icon")
    private String icon;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty("备注信息")
    @TableField("note")
    private String note;

    @ApiModelProperty("最后登录时间")
    @TableField("login_time")
    private LocalDateTime loginTime;

    @ApiModelProperty("帐号启用状态：0->禁用；1->启用")
    @TableField("status")
    private Integer status;

}




