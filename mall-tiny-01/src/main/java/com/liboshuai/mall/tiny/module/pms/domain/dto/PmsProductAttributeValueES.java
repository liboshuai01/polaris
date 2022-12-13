package com.liboshuai.mall.tiny.module.pms.domain.dto;

import java.io.Serializable;

/**
 * @Auther: Bernardo
 * @Date: 2022/12/13 23:56
 * @Description:
 */
public class PmsProductAttributeValueES implements Serializable {

    private static final long serialVersionUID = -3195101467897807261L;

    private Long productAttributeId;

    private Long productId;

    /**
     * 动添加规格或参数的值，参数单值，规格有多个时以逗号隔开
     */
    private String value;
}
