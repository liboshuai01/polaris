package com.liboshuai.mall.tiny.nosql.elasticsearch.document;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @Author: liboshuai
 * @Date: 2022-12-02 15:49
 * @Description:
 */
public class EsProductAttributeValue implements Serializable {
    private static final long serialVersionUID = -4782978728804424777L;

    private Long id;

    /**
     * 产品属性分类id
     */
    private Long productAttributeCategoryId;

    /**
     * 商品属性值
     */
    @Field(type = FieldType.Keyword)
    private String value;

    /**
     * 商品属性参数：0->规格；1->参数
     */
    private Integer type;

    /**
     * 商品属性名称
     */
    @Field(type=FieldType.Keyword)
    private String name;
}
