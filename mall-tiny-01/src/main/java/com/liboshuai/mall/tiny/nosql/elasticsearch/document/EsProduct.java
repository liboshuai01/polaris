package com.liboshuai.mall.tiny.nosql.elasticsearch.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-10-10 01:16
 * @Description: es搜索商品信息
 */
@Data
@Document(indexName = "dangdang", type = "book", shards = 1, replicas = 0)
public class EsProduct implements Serializable {
    private static final long serialVersionUID = -7441167196478327398L;

    @Id
    private Long id;

    /**
     * 货号
     */
    @Field(type = FieldType.Keyword)
    private String productSn;

    /**
     * 品牌名称
     */
    @Field(type = FieldType.Keyword)
    private String brandName;

    /**
     * 商品类别名称
     */
    @Field(type = FieldType.Keyword)
    private String productCategoryName;

    /**
     * 商品名称
     */
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String name;

    /**
     * 商品标题
     */
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String subTitle;

    /**
     * 商品关键字
     */
    @Field(analyzer = "ik_max_word",type = FieldType.Text)
    private String keywords;

    /**
     * 商品属性参数列表
     */
    @Field(type =FieldType.Nested)
    private List<EsProductAttributeValue> attrValueList;
}
