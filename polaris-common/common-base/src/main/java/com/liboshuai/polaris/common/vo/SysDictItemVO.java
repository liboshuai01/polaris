package com.liboshuai.polaris.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author: liboshuai
 * @Date: 2023-01-13 16:45
 * @Description:
 */
@Data
@ApiModel(value="字典项vo对象", description="字典项vo对象")
public class SysDictItemVO implements Serializable {

    private static final long serialVersionUID = -8747450949014101973L;

    public SysDictItemVO() {
    }

    public SysDictItemVO(String value, String text) {
        this.value = value;
        this.text = text;
    }

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
