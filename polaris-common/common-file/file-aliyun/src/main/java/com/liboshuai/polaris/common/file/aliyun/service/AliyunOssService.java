package com.liboshuai.polaris.common.file.aliyun.service;

import com.liboshuai.polaris.common.file.aliyun.vo.AliyunOssCallbackParam;
import com.liboshuai.polaris.common.file.aliyun.vo.AliyunOssCallbackResult;
import com.liboshuai.polaris.common.file.aliyun.vo.AliyunOssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: liboshuai
 * @Date: 2023-02-13 17:35
 * @Description:
 */
public interface AliyunOssService {
    /**
     * oss上传策略生成
     */
    AliyunOssPolicyResult policy();

    /**
     * oss上传成功回调
     */
    AliyunOssCallbackResult callback(HttpServletRequest request);
}
