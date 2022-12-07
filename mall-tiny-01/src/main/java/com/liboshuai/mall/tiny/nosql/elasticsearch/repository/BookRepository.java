//package com.liboshuai.mall.tiny.nosql.elasticsearch.repository;
//
//import com.liboshuai.mall.tiny.nosql.elasticsearch.document.Book;
//import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
//
//import java.util.List;
//
///**
// * @Author: liboshuai
// * @Date: 2022-11-02 21:47
// * @Description:
// */
//public interface BookRepository extends ElasticsearchRepository<Book, String> {
//
//    /**
//     * 根据作者查询
//     */
//    List<Book> findByAuthor(String author);
//
//    /**
//     * 根据内容查询
//     */
//    List<Book> findByContent(String content);
//
//
//    /**
//     * 根据内容和名字查询
//     */
//    List<Book> findByNameAndContent(String name, String content);
//
//    /**
//     * 范围查询
//     */
//    List<Book> findByPriceBetween(Float startPrice, Float endPrice);
//
//    /**
//     * 查询以指定名称开头的book
//     */
//    List<Book> findByNameStartingWith(String name);
//
//    /**
//     * 查询show字段值为true
//     */
//    List<Book> findByShowTrue();
//}
