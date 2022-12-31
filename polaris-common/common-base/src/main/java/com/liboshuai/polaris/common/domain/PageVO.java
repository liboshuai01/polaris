package com.liboshuai.polaris.common.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-12-27 17:29
 * @Description: 基础分页查询结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("基础分页查询结果")
public class PageVO<T> {
    @ApiModelProperty("分页数据")
    private List<T> records;

    @ApiModelProperty("总记录数")
    private Integer total;

    @ApiModelProperty("每页记录数")
    private Integer size;

    @ApiModelProperty("当前页码")
    private Integer current;
}

