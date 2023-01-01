package com.liboshuai.polaris.security.query;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 00:21
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginQuery {

    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
