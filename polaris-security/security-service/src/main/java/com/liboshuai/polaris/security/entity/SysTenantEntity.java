package com.liboshuai.polaris.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.polaris.common.domain.BaseEntity;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 20:59
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_tenant")
public class SysTenantEntity extends BaseEntity {
    private static final long serialVersionUID = 4724985269441236055L;

    /**
     * 租户名称
     */
    private String name;

    /**
     * 开始时间
     */
    private Date beginDate;

    /**
     * 结束时间
     */
    private Date endDate;

    /**
     * 状态: 1-正常, 0-冻结
     */
    private Integer status;

}
