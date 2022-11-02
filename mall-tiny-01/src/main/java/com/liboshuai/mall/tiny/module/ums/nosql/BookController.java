package com.liboshuai.mall.tiny.module.ums.nosql;

import com.liboshuai.mall.tiny.compone.response.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
     * 添加索引和更新索引id, 存在则更新,不存在则添加
     */
    @ApiOperation(value = "添加或更新book到es中", httpMethod = "POST")
    @PostMapping("/saveOrUpdateBookEs")
    public ResponseResult<Book> saveOrUpdateBookEs(@RequestBody Book book) {
        Book save = bookRepository.save(book);
        return ResponseResult.success(save);
    }
}
