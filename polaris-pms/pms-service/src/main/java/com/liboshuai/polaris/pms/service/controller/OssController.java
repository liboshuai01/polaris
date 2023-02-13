package com.liboshuai.polaris.pms.service.controller;

import com.liboshuai.polaris.common.domain.ResponseResult;
import com.liboshuai.polaris.common.file.aliyun.service.OssService;
import com.liboshuai.polaris.common.file.aliyun.vo.AliyunOssCallbackResult;
import com.liboshuai.polaris.common.file.aliyun.vo.AliyunOssPolicyResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: liboshuai
 * @Date: 2023-02-13 18:03
 * @Description:
 */
@Slf4j
@Controller
@Api(tags = "OssController", description = "Oss管理")
@NoArgsConstructor
@RequestMapping("/aliyun/oss")
public class OssController {

    private OssService ossService;

    @Autowired
    public OssController(OssService ossService) {
        this.ossService = ossService;
    }

    @ApiOperation(value = "oss上传签名生成")
    @RequestMapping(value = "/policy", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult<AliyunOssPolicyResult> policy() {
        AliyunOssPolicyResult result = ossService.policy();
        return ResponseResult.success(result);
    }

    @ApiOperation(value = "oss上传成功回调")
    @RequestMapping(value = "/callback", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<AliyunOssCallbackResult> callback(HttpServletRequest request) {
        log.info("--------进入oss回调接口--------");
        AliyunOssCallbackResult ossCallbackResult = ossService.callback(request);
        return ResponseResult.success(ossCallbackResult);
    }

}
