package com.liboshuai.mall.tiny.nosql.elasticsearch;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * @Author: liboshuai
 * @Date: 2022-12-08 19:55
 * @Description: es创建索引
 */
@Slf4j
public class RestHighLevClientForIndexTests extends MallTiny01TestApplication{

    private final RestHighLevelClient restHighLevelClient;

    @Autowired
    public RestHighLevClientForIndexTests(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    private static final String INDEX_NAME = "product";

    /**
     * 删除索引
     */
    @Test
    public void testDeleteIndex() throws IOException {
        //参数 1: 删除索引对象  参数 2:请求配置对象
        AcknowledgedResponse product = restHighLevelClient.indices().delete(new DeleteIndexRequest(INDEX_NAME), RequestOptions.DEFAULT);
        log.info("删除索引: {}", JSONObject.toJSONString(product));
    }

    /**
     * 创建索引和映射
     */
    @Test
    public void testCreateIndexAndMapping() throws IOException {
        //参数 1: 创建索引请求对象  参数 2: 请求配置对象
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(INDEX_NAME);
        //指定映射 参数 1: 指定映射 json 结构  参数 2:指定数据类型
        createIndexRequest.mapping("{\n" +
                "    \"properties\": {\n" +
                "        \"brand_name\": {\n" +
                "            \"type\": \"keyword\"\n" +
                "        },\n" +
                "        \"create_time\": {\n" +
                "            \"type\": \"date\"\n" +
                "        },\n" +
                "        \"id\": {\n" +
                "            \"type\": \"long\"\n" +
                "        },\n" +
                "        \"keywords\": {\n" +
                "            \"type\": \"text\",\n" +
                "            \"analyzer\": \"ik_max_word\"\n" +
                "        },\n" +
                "        \"name\": {\n" +
                "            \"type\": \"text\",\n" +
                "            \"analyzer\": \"ik_max_word\"\n" +
                "        },\n" +
                "        \"product_attribute_value\": {\n" +
                "            \"type\": \"nested\",\n" +
                "            \"properties\": {\n" +
                "                \"product_attribute_id\": {\n" +
                "                    \"type\": \"long\"\n" +
                "                },\n" +
                "                \"product_id\": {\n" +
                "                    \"type\": \"long\"\n" +
                "                },\n" +
                "                \"value\": {\n" +
                "                    \"type\": \"keyword\"\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        \"product_category_name\": {\n" +
                "            \"type\": \"keyword\"\n" +
                "        },\n" +
                "        \"sub_title\": {\n" +
                "            \"type\": \"text\",\n" +
                "            \"analyzer\": \"ik_max_word\"\n" +
                "        },\n" +
                "        \"update_time\": {\n" +
                "            \"type\": \"date\"\n" +
                "        }\n" +
                "    }\n" +
                "}", XContentType.JSON);
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        log.info("创建状态: {}", createIndexResponse.isAcknowledged());
        // 关闭资源
        restHighLevelClient.close();
    }
}
