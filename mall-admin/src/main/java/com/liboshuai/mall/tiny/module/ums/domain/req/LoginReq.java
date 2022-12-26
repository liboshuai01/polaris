package com.liboshuai.mall.tiny.module.ums.domain.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

/**
 * @Auther: Bernardo
 * @Date: 2022/12/17 23:25
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginReq implements Serializable {
    private static final long serialVersionUID = 7713611503580917143L;

    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
