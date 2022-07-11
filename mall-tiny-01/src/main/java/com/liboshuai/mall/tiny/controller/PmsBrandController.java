package com.liboshuai.mall.tiny.controller;

import com.liboshuai.mall.tiny.common.api.CommonResult;
import com.liboshuai.mall.tiny.common.vo.PmsBrandVO;
import com.liboshuai.mall.tiny.domain.dao.PmsBrandDAO;
import com.liboshuai.mall.tiny.service.PmsBrandService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-07-11 09:56
 * @Description: 品牌Controller
 */
@RestController
@RequestMapping(value = "/pmsBrand")
@Slf4j
@NoArgsConstructor
public class PmsBrandController {

    private PmsBrandService pmsBrandService;

    @Autowired
    public PmsBrandController(PmsBrandService pmsBrandService) {
        this.pmsBrandService = pmsBrandService;
    }

    @PostMapping("/listAllBrand")
    public CommonResult<List<PmsBrandDAO>> listAllBrand() {
        return CommonResult.success(pmsBrandService.listAllBrand());
    }

    @PostMapping("/createPmsBrand")
    public CommonResult<PmsBrandVO> createPmsBrand(@RequestBody PmsBrandVO pmsBrandVO){
        int createPmsBrandResult = pmsBrandService.createPmsBrand(pmsBrandVO);
        if (createPmsBrandResult == 1) {
            log.info("createPmsBrand創建成功，pmsBrandVO: {}", pmsBrandVO);
            return CommonResult.success(pmsBrandVO);
        } else {
            log.info("createPmsBrand創建失敗，pmsBrandVO: {}", pmsBrandVO);
            return CommonResult.failed();
        }
    }
}
