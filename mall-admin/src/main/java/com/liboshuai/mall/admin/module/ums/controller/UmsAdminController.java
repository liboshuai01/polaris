package com.liboshuai.mall.admin.module.ums.controller;


import com.alibaba.fastjson.JSONObject;
import com.liboshuai.mall.admin.compone.response.ResponseResult;
import com.liboshuai.mall.admin.module.ums.domain.vo.UmsAdminVO;
import com.liboshuai.mall.admin.module.ums.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 后台用户表 前端控制器
 * </p>
 *
 * @author liboshuai
 * @since 2022-09-16
 */
@Slf4j
@RestController
@RequestMapping("/mall.tiny.module.ums/ums-admin")
@Api(tags = "用户后台", value = "UmsAdminController")
public class UmsAdminController {

    @Autowired
    private UmsAdminService umsAdminService;


    /**
     * 批量更新用户信息
     */
    @ApiOperation(value = "批量更新用户信息", httpMethod = "POST")
    @PostMapping("/updateBatchUserById")
    public ResponseResult<?> updateBatchUserById(@RequestBody List<UmsAdminVO> umsAdminVOList) {
        if (CollectionUtils.isEmpty(umsAdminVOList)) {
            return ResponseResult.fail();
        }
        log.info("日志umsAdminVOList:{}", JSONObject.toJSONString(umsAdminVOList));
        int result = umsAdminService.updateBatchUserById(umsAdminVOList);
        return ResponseResult.success("更新成功的数据条数: " + result);
    }
}
