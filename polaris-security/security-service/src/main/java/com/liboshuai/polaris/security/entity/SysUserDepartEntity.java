package com.liboshuai.polaris.security.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.liboshuai.polaris.common.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 22:14
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_user_depart")
public class SysUserDepartEntity extends BaseEntity {

    private static final long serialVersionUID = 8012885420764304391L;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 部门id
     */
    private String depId;
}
