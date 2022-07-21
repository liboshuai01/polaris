package com.liboshuai.mall.tiny.service;

import com.liboshuai.mall.tiny.common.api.CommonResult;
import org.springframework.stereotype.Service;

/**
 * @Author: liboshuai
 * @Date: 2022-07-21 14:48
 * @Description:
 */
@Service
public interface UmsMemberService {

    /**
     * 根据电话号码，生成验证码
     *
     * @param telephone 电话号码
     * @return 验证码
     */
    CommonResult<String> generateAuthCode(String telephone);

    /**
     * 效验验证码是否正确
     *
     * @param telephone 电话号码
     * @param authCode  验证码
     * @return 是否正确结果
     */
    CommonResult<Object> verifyAuthCode(String telephone, String authCode);

    /**
     * 效验手机号是否已经获取了验证码
     *
     * @param telephone 手机号
     * @return 手机号是否已经存在
     */
    CommonResult<Object> verifyTelephoneNumExists(String telephone);
}
