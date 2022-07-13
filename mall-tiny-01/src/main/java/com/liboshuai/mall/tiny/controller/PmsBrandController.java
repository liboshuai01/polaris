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
            return CommonResult.success(pmsBrandVO, "添加一条品牌数据成功");
        } else {
            log.info("createPmsBrand創建失敗，pmsBrandVO: {}", pmsBrandVO);
            return CommonResult.failed("添加一条品牌数据失败");
        }
    }

    @PostMapping("/updatePmsBrand")
    public CommonResult<PmsBrandVO> updatePmsBrand(@RequestBody PmsBrandVO pmsBrandVO) {
        int updatePmsBrandResult = pmsBrandService.updatePmsBrand(pmsBrandVO);
        if (updatePmsBrandResult == 1) {
            log.info("updatePmsBrand更新成功，param: {}", pmsBrandVO);
            return CommonResult.success(pmsBrandVO, "更新一条品牌数据成功");
        } else {
            log.info("updatePmsBrand更新失败，param: {}", pmsBrandVO);
            return CommonResult.success(pmsBrandVO, "更新失败一条品牌数据");
        }
    }
}
