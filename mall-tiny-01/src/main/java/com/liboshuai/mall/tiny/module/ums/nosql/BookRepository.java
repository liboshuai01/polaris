package com.liboshuai.mall.tiny.module.ums.nosql;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author: liboshuai
 * @Date: 2022-11-02 21:47
 * @Description:
 */
public interface BookRepository extends ElasticsearchRepository<Book, String> {
}
