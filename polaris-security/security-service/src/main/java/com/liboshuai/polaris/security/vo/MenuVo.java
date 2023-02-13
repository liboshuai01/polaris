package com.liboshuai.polaris.security.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author: liboshuai
 * @Date: 2023-02-13 15:43
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="菜单vo", description="菜单vo")
public class MenuVo {

    private Date createTime;

    private Integer hidden;

    private String icon;

    private Long id;

    private Integer level;

    private String name;

    private Integer parentId;

    private Integer sort;

    private String title;
}
