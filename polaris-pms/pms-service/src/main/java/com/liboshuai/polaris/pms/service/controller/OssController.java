package com.liboshuai.polaris.pms.service.controller;

import com.liboshuai.polaris.common.domain.ResponseResult;
import com.liboshuai.polaris.common.file.aliyun.service.AliyunOssService;
import com.liboshuai.polaris.common.file.aliyun.vo.AliyunOssCallbackResult;
import com.liboshuai.polaris.common.file.aliyun.vo.AliyunOssPolicyResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Controller
@Api(tags = "OssController", description = "Oss管理")
@RequestMapping("/aliyun/oss")
public class OssController {
    @Autowired
    private AliyunOssService ossService;

    @ApiOperation(value = "oss上传签名生成")
    @RequestMapping(value = "/policy", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult<AliyunOssPolicyResult> policy() {
        AliyunOssPolicyResult result = ossService.policy();
        return ResponseResult.success(result);
    }

    @ApiOperation(value = "oss上传成功回调")
    @RequestMapping(value = "callback", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<AliyunOssCallbackResult> callback(HttpServletRequest request) {
        AliyunOssCallbackResult ossCallbackResult = ossService.callback(request);
        return ResponseResult.success(ossCallbackResult);
    }

}
