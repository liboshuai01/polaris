package com.liboshuai.mall.admin.module.ums.domain.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.mall.admin.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * <p>
 * 后台用户和角色关系表
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Data
@TableName("ums_admin_role_relation")
@ApiModel(value = "UmsAdminRoleRelation对象", description = "后台用户和角色关系表")
public class UmsAdminRoleRelation extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("admin_id")
    private Long adminId;

    @TableField("role_id")
    private Long roleId;

}




