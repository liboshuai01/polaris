package com.liboshuai.polaris.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.polaris.common.domain.BaseEntity;
import lombok.*;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 03:14
 * @Description: 后台菜单表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("ums_menu")
public class UmsMenuEntity extends BaseEntity {
    private static final long serialVersionUID = 7338179423080707291L;

    /**
     * 父级ID
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String title;

    /**
     * 菜单级数
     */
    private Integer level;

    /**
     * 菜单排序
     */
    private Integer sort;

    /**
     * 前端名称
     */
    private String name;

    /**
     * 前端图标
     */
    private String icon;

    /**
     * 前端是否隐藏展示
     */
    private Integer hidden;

}
