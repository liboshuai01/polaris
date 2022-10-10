package com.liboshuai.mall.tiny.nosql.elasticsearch.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @Author: liboshuai
 * @Date: 2022-10-10 01:16
 * @Description: es搜索商品信息
 */
@Data
@Document(indexName = "pms", type = "product", shards = 1, replicas = 0)
public class EsProduct implements Serializable {
    private static final long serialVersionUID = -7441167196478327398L;

    @Id
    private Long id;

    @Field(type = FieldType.Keyword)
    private String productSn;
}
