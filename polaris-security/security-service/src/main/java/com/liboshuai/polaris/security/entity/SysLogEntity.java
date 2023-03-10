package com.liboshuai.polaris.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.polaris.common.domain.BaseEntity;
import lombok.*;

/**
 * @Author: liboshuai
 * @Date: 2023-01-17 18:34
 * @Description: 系统日志实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sys_log")
public class SysLogEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 耗时
     */
    private Long costTime;

    /**
     * IP
     */
    private String ip;

    /**
     * 请求参数
     */
    private String requestParam;

    /**
     * 请求类型
     */
    private String requestType;

    /**
     * 请求路径
     */
    private String requestUrl;
    /**
     * 请求方法
     */
    private String method;

    /**
     * 操作人用户名称
     */
    private String username;
    /**
     * 操作人用户账户
     */
    private String userid;
    /**
     * 操作详细日志
     */
    private String logContent;

    /**
     * 日志类型（1登录日志，2操作日志）
     */
    private Integer logType;

    /**
     * 操作类型（1查询，2添加，3修改，4删除,5导入，6导出）
     */
    private Integer operateType;
}
