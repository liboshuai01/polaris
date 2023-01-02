package com.liboshuai.polaris.security.vo;

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

    @ApiModelProperty("token值")
    private String token;

    @ApiModelProperty("租户列表")
    private List<SysTenantVO> tenantList;

    @ApiModelProperty("用户信息")
    private SysUserVO userInfo;

    @ApiModelProperty("机构信息")
    private List<SysDepartVO> departs;

    private Integer multi_depart;

    @ApiModelProperty("词典项")
    private Map<String,List<SysDictItemVO>> sysAllDictItems;
}
