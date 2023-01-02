package com.liboshuai.polaris.security.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 00:21
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="登录请求入参对象", description="登录请求入参对象")
public class LoginQuery {

    @NotNull(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @NotNull(message = "密码不能为空")
    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @NotNull(message = "验证码不能为空")
    @ApiModelProperty(value = "验证码", required = true)
    private String captcha;

    @NotNull(message = "验证码key不能为空")
    @ApiModelProperty(value = "验证码key", required = true)
    private String checkKey;

}
