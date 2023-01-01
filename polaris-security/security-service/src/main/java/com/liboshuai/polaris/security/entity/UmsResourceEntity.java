package com.liboshuai.polaris.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.polaris.common.domain.BaseEntity;
import lombok.*;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 03:28
 * @Description: 后台资源表
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("ums_resource")
public class UmsResourceEntity extends BaseEntity {
    private static final long serialVersionUID = 4545984948930364578L;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源URL
     */
    private String url;

    /**
     * 描述
     */
    private String description;

    /**
     * 资源分类ID
     */
    private Long categoryId;
}

