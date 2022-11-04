package com.liboshuai.mall.tiny.nosql.elasticsearch.document;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-11-02 21:47
 * @Description:
 */
public interface BookRepository extends ElasticsearchRepository<Book, String> {

    /**
     * 根据作者查询
     */
    List<Book> findByAuthor(String author);

    /**
     * 根据内容查询
     */
    List<Book> findByContent(String content);

}
