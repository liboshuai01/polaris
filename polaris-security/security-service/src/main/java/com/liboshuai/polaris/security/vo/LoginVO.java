package com.liboshuai.polaris.security.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: liboshuai
 * @Date: 2023-02-13 15:48
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="登录接口vo", description="登录接口vo")
public class LoginVO {
    private String token;

    private String tokenHead;
}
