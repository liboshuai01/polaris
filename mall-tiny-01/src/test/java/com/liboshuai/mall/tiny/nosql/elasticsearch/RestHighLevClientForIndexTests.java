package com.liboshuai.mall.tiny.nosql.elasticsearch;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
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
//        createIndexRequest.mapping()
    }
}
