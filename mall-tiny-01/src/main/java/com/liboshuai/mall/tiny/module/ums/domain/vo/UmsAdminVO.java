package com.liboshuai.mall.tiny.module.ums.domain.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: liboshuai
 * @Date: 2022-09-10 14:56
 * @Description: 用户注册登录退出vo
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UmsAdminVO implements Serializable {
    private static final long serialVersionUID = 1321190682152399912L;

    @ApiModelProperty("用户名")
    @Excel(name = "用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("头像")
    @Excel(name = "头像")
    private String icon;

    @ApiModelProperty("邮箱")
    @Excel(name = "邮箱")
    private String email;

    @ApiModelProperty("昵称")
    @Excel(name = "昵称")
    private String nickName;

    @ApiModelProperty("备注信息")
    @Excel(name = "备注信息")
    private String note;

}
