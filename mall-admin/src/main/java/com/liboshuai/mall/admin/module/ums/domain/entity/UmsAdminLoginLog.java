package com.liboshuai.mall.admin.module.ums.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 后台用户登录日志表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("ums_admin_login_log")
@ApiModel(value = "UmsAdminLoginLog对象", description = "后台用户登录日志表")
public class UmsAdminLoginLog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("admin_id")
    private Long adminId;

    @TableField("ip")
    private String ip;

    @TableField("address")
    private String address;

    @ApiModelProperty("浏览器登录类型")
    @TableField("user_agent")
    private String userAgent;

}




