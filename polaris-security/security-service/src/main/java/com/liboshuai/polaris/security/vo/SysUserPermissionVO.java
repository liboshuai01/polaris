package com.liboshuai.polaris.security.vo;

import com.alibaba.fastjson.JSONArray;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: liboshuai
 * @Date: 2023-01-18 17:07
 * @Description: 用户权限VO对象
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="用户权限VO对象", description="用户权限VO对象")
public class SysUserPermissionVO implements Serializable {
    private static final long serialVersionUID = 4352734357415382249L;

    private JSONArray allAuth;

    private JSONArray auth;

    private JSONArray menu;

    private Boolean sysSafeMode;
}
