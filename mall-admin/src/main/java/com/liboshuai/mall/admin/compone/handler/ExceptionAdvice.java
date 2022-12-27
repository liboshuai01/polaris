package com.liboshuai.mall.admin.compone.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author: liboshuai
 * @Date: 2022-09-10 00:34
 * @Description: 异常捕捉增强类
 */
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

    /**
     * 获取效验错误信息
     */
    private Map<String, Object> getValidError(List<FieldError> fieldErrors) {
        Map<String, Object> map = new HashMap<>(16);
        List<String> errorList = new ArrayList<>();
        StringBuffer errorMsg = new StringBuffer("效验异常(ValidException):");
        for (FieldError error :
                fieldErrors) {
            errorList.add(error.getField() + "-" + error.getDefaultMessage());
            errorMsg.append(error.getField() + "-" + error.getDefaultMessage() + "-");
        }
        map.put("errorList", errorList);
        map.put("errorMsg", errorMsg);
        return map;
    }
}
