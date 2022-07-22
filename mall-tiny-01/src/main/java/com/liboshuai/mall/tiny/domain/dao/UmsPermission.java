package com.liboshuai.mall.tiny.domain.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author: liboshuai
 * @Date: 2022-07-22 13:26
 * @Description: 用户权限关联表
 */
@Data
@TableName(value = "ums_permission", schema = "mall")
public class UmsPermission {

    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    /**
     * 父级权限id
     */
    @TableField(value = "pid")
    private Long pid;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 权限值
     */
    @TableField(value = "value")
    private String value;

    /**
     * 图标
     */
    @TableField(value = "icon")
    private String icon;

    /**
     * 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
     */
    @TableField(value = "type")
    private Integer type;

    /**
     * 前端资源路径
     */
    @TableField(value = "uri")
    private String uri;

    /**
     * 启用状态；0->禁用；1->启用
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private String createTime;

    /**
     * 排序
     */
    @TableField(value = "sort")
    private Integer sort;
}
