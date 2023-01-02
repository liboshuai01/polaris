package com.liboshuai.polaris.security.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 18:27
 * @Description:
 */
@Data
public class SysDictItemDTO implements Serializable {

    private static final long serialVersionUID = -3074570236291833739L;

    public SysDictItemDTO() {
    }

    public SysDictItemDTO(String value, String text) {
        this.value = value;
        this.text = text;
    }

    /**
     * 字典value
     */
    private String value;

    /**
     * 字典文本
     */
    private String text;

    /**
     * 特殊用途： JgEditableTable
     */
    public String title = text;

    /**
     * 特殊用途： vue3 Select组件
     */
    public String label = text;
}
