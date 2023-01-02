package com.liboshuai.polaris.security.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 17:29
 * @Description:
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value="字典项vo对象", description="字典项vo对象")
public class SysDictItemVO implements Serializable {

    private static final long serialVersionUID = -8747450949014101973L;

    /**
     * 字典value
     */
    @ApiModelProperty("字典value")
    private String value;
    /**
     * 字典文本
     */
    @ApiModelProperty("字典文本")
    private String text;

    /**
     * 特殊用途： JgEditableTable
     */
    @ApiModelProperty("特殊用途： JgEditableTable")
    public String title = text;
    /**
     * 特殊用途： vue3 Select组件
     */
    @ApiModelProperty("特殊用途： vue3 Select组件")
    public String label = text;
}
