package com.liboshuai.polaris.security.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 21:13
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysTenantDTO implements Serializable {

    private static final long serialVersionUID = 1139683322753900471L;
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
