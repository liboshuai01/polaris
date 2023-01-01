package com.liboshuai.polaris.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.polaris.common.domain.BaseEntity;
import lombok.*;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 03:37
 * @Description: 资源分类表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("ums_resource_category")
public class UmsResourceCategoryEntity extends BaseEntity {
    private static final long serialVersionUID = -1854833836772843350L;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;
}
