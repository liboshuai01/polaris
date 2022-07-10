package com.liboshuai.mall.tiny.controller;

import com.liboshuai.mall.tiny.domain.dao.UmsAdminDao;
import com.liboshuai.mall.tiny.service.UmsAdminService;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-07-10 20:35
 * @Description: 请求返回码
 */
@RestController
@Log4j
@NoArgsConstructor
@RequestMapping(value = "/umsAdmin")
public class UmsAdminController {

    private UmsAdminService umsAdminService;

    @Autowired
    public UmsAdminController(UmsAdminService umsAdminService) {
        this.umsAdminService = umsAdminService;
    }

    @GetMapping("/findAllByUsername/{username}")
    public List<UmsAdminDao> findAllByUsername(@PathVariable String username) {
        return umsAdminService.findAllByUsername(username);
    }
}
