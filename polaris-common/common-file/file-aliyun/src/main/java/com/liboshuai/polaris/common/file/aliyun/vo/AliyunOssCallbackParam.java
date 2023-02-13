package com.liboshuai.polaris.common.file.aliyun.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author: liboshuai
 * @Date: 2023-02-13 17:33
 * @Description: 阿里云文件上传回调入参
 */
@Data
public class AliyunOssCallbackParam {
    @ApiModelProperty("请求的回调地址")
    private String callbackUrl;
    @ApiModelProperty("回调是传入request中的参数")
    private String callbackBody;
    @ApiModelProperty("回调时传入参数的格式，比如表单提交形式")
    private String callbackBodyType;
}
