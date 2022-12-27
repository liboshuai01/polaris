package com.liboshuai.mall.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: liboshuai
 * @Date: 2022-12-27 17:28
 * @Description: 基础分页查询参数
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("基础分页查询参数")
public class PageParam {
    @ApiModelProperty("页码")
    private Integer pageNum;

    @ApiModelProperty("每页数据量")
    private Integer pageSize;

    @ApiModelProperty("排序字段")
    private String orderColumn;

    @ApiModelProperty("是否降序")
    private Boolean isDesc;
}
