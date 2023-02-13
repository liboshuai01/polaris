package com.liboshuai.polaris.security.vo;

import com.liboshuai.polaris.common.vo.SysDictItemVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 17:04
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="用户登录信息vo对象", description="用户登录信息vo对象")
public class SysUserInfoVO implements Serializable {

    private static final long serialVersionUID = 4850593451825428233L;

    @ApiModelProperty("图标")
    private String icon;

    @ApiModelProperty("菜单列表")
    private List<MenuVo> menus;

    @ApiModelProperty("角色列表")
    private List<String> roles;

    @ApiModelProperty("用户名")
    private String username;

}
