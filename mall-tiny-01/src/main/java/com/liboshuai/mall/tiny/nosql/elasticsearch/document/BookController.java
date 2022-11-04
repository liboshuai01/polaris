package com.liboshuai.mall.tiny.nosql.elasticsearch.document;

import com.liboshuai.mall.tiny.compone.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


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
}
