package com.liboshuai.mall.oms.service.config;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;


/**
 * @Auther: 李博帅
 * @Date: 2022/12/6 21:03
 * @Description: elasticsearch配置类
 */
@Configuration
public class ElasticSearchConfig extends AbstractElasticsearchConfiguration {

    @Value("${elasticSearch.host}")
    private String elasticSearchHost;

    @Value("${elasticSearch.port}")
    private int elasticSearchPort;

    @Value("${elasticSearch.scheme}")
    private String elasticSearchScheme;

    @Value("${elasticSearch.userName}")
    private String elasticSearchUserName;

    @Value("${elasticSearch.password}")
    private String elasticSearchPassword;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {
        final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials(elasticSearchUserName, elasticSearchPassword));
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost(elasticSearchHost, elasticSearchPort, elasticSearchScheme))
                        .setHttpClientConfigCallback(httpClientBuilder -> {
                            httpClientBuilder.disableAuthCaching();
                            return httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);
                        }));
    }

}
