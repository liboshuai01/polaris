package com.liboshuai.mall.admin.module.ums.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: liboshuai
 * @Date: 2022-07-27 19:18
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UmsAdminLoginParam {

    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

}
