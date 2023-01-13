package com.liboshuai.polaris.security.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.polaris.common.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Author: liboshuai
 * @Date: 2023-01-13 14:45
 * @Description: 角色首页配置
 */
@Data
@TableName("sys_role_index")
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysRoleIndexEntity extends BaseEntity {

    /**角色编码*/
    private java.lang.String roleCode;
    /**路由地址*/
    private java.lang.String url;
    /**路由地址*/
    private java.lang.String component;
    /**
     * 是否路由菜单: 0:不是  1:是（默认值1）
     */
    @TableField(value="is_route")
    private boolean route;
    /**优先级*/
    private java.lang.Integer priority;
    /**路由地址*/
    private java.lang.String status;
    /**所属部门*/
    private java.lang.String sysOrgCode;


    public SysRoleIndexEntity() {

    }
    public SysRoleIndexEntity(String componentUrl){
        this.component = componentUrl;
    }
}
