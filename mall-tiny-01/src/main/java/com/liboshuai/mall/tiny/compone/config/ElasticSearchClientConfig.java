package com.liboshuai.mall.tiny.compone.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: liboshuai
 * @Date: 2022-12-02 15:11
 * @Description: es配置类
 */

@Configuration
public class ElasticSearchClientConfig {

    @Value("${spring.ElasticSearch.host}")
    private String host;

    @Value("${spring.ElasticSearch.port}")
    private int port;

    @Value("${spring.ElasticSearch.scheme}")
    private String scheme;

    @Bean
    public RestHighLevelClient restHighLevelClient(){
        return new RestHighLevelClient(
                RestClient.builder(new HttpHost(host,port,scheme)));
    }
}
