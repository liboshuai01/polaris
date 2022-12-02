package com.liboshuai.mall.tiny.nosql.elasticsearch.document;

import com.liboshuai.mall.tiny.common.base.PageResult;
import com.liboshuai.mall.tiny.compone.response.ResponseResult;
import com.liboshuai.mall.tiny.nosql.elasticsearch.repository.BookRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Author: liboshuai
 * @Date: 2022-11-02 21:49
 * @Description:
 */
@Api(tags = "书籍es搜索", value = "BookController")
@Slf4j
@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private RestHighLevelClient restHighLevelClient;


    /**
     * 添加或更新一条book到es中
     */
    @ApiOperation(value = "添加或更新一条book到es中", httpMethod = "POST")
    @PostMapping("/saveOrUpdateBookEs")
    public ResponseResult<Book> saveOrUpdateBookEs(@RequestBody Book book) {
        Book save = bookRepository.save(book);
        return ResponseResult.success(save);
    }

    /**
     * 删除一条book到es中
     */
    @ApiOperation(value = "删除一条book到es中", httpMethod = "POST")
    @PostMapping("/deleteBookEs")
    public ResponseResult<Book> deleteBookEs(@RequestParam String id) {
        Book book = Book.builder().id(id).build();
        bookRepository.delete(book);
        return ResponseResult.success("删除成功");
    }

    /**
     * 查询es中所有book数据
     */
    @ApiOperation(value = "查询es中所有book数据", httpMethod = "POST")
    @PostMapping("/findAllBookEs")
    public ResponseResult<Iterable<Book>> findAllBookEs() {
        Iterable<Book> bookAllList = bookRepository.findAll();
        return ResponseResult.success(bookAllList);
    }

    /**
     * 查询es中一条book数据
     */
    @ApiOperation(value = "查询es中一条book数据", httpMethod = "POST")
    @PostMapping("/findOneBookEs")
    public ResponseResult<Book> findOneBookEs(@RequestParam String id) {
        Book book = bookRepository.findById(id).get();
        return ResponseResult.success(book);
    }

    /**
     * 查询es中所有book数据,并根据创建时间进行排序
     */
    @ApiOperation(value = "查询es中所有book数据,并根据创建时间进行排序", httpMethod = "POST")
    @PostMapping("/findAllOrderByCreateDate")
    public ResponseResult<Iterable<Book>> findAllOrderByCreateDate() {
        Iterable<Book> books = bookRepository.findAll(Sort.by(Sort.Order.asc("createDate")));
        return ResponseResult.success(books);
    }

    /**
     * 根据作者名称查询
     */
    @ApiOperation(value = "根据作者名称查询", httpMethod = "POST")
    @PostMapping("/findByAuthor")
    public ResponseResult<List<Book>> findByAuthor(String author) {
        List<Book> bookList = bookRepository.findByAuthor(author);
        return ResponseResult.success(bookList);
    }

    /**
     * 根据内容查询
     */
    @ApiOperation(value = "根据内容查询", httpMethod = "POST")
    @PostMapping("/findByContent")
    public ResponseResult<List<Book>> findByContent(String content) {
        List<Book> bookList = bookRepository.findByContent(content);
        return ResponseResult.success(bookList);
    }

    /**
     * 根据内容和名字查询
     */
    @ApiOperation(value = "根据内容和名字查询", httpMethod = "POST")
    @PostMapping("/findByNameAndContent")
    public ResponseResult<List<Book>> findByNameAndContent(@RequestParam String name, @RequestParam String content) {
        List<Book> bookList = bookRepository.findByNameAndContent(name, content);
        return ResponseResult.success(bookList);
    }

    /**
     * 范围查询
     */
    @ApiOperation(value = "范围查询", httpMethod = "POST")
    @PostMapping("/findByPriceBetween")
    public ResponseResult<List<Book>> findByPriceBetween(@RequestParam Float startPrice, @RequestParam Float endPrice) {
        List<Book> bookList = bookRepository.findByPriceBetween(startPrice, endPrice);
        return ResponseResult.success(bookList);
    }

    /**
     * 范围查询
     */
    @ApiOperation(value = "范围查询", httpMethod = "POST")
    @PostMapping("/findByNameStartingWith")
    public ResponseResult<List<Book>> findByNameStartingWith(@RequestParam String name) {
        List<Book> bookList = bookRepository.findByNameStartingWith(name);
        return ResponseResult.success(bookList);
    }

    /**
     * 查询show字段值为true
     */
    @ApiOperation(value = "查询show字段值为true", httpMethod = "POST")
    @PostMapping("/findByShowTrue")
    public ResponseResult<List<Book>> findByShowTrue() {
        List<Book> bookList = bookRepository.findByShowTrue();
        return ResponseResult.success(bookList);
    }


    /**
     * es分页查询
     */
    @ApiOperation(value = "es分页查询", httpMethod = "POST")
    @PostMapping("/findAllPage")
    public ResponseResult<PageResult<Book>> findAllPage(@RequestParam int pageNum, @RequestParam int pageSize) {
//        SearchRequest searchRequest = new SearchRequest();
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.from(0).size(2).sort("age", SortOrder.DESC).query(QueryBuilders.matchAllQuery());
//        searchRequest.indices("ems").types("emp").source(sourceBuilder);
//        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHit[] hits = search.getHits().getHits();
//        for (SearchHit hit : hits) {
//            System.out.println(hit.getSourceAsString());
//        }
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.from(pageNum).size(pageSize)
                .sort("createDate", SortOrder.DESC)
                .query(QueryBuilders.matchAllQuery());
        searchRequest.indices("dangdang").types("book").source(searchSourceBuilder);
//        SearchResponse search = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        return ResponseResult.success();
    }
}
