package com.liboshuai.mall.tiny.service.impl;

import com.liboshuai.mall.tiny.common.api.CommonResult;
import com.liboshuai.mall.tiny.redis.RedisService;
import com.liboshuai.mall.tiny.service.UmsMemberService;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

/**
 * @Author: liboshuai
 * @Date: 2022-07-21 14:51
 * @Description:
 */
@Service
@Slf4j
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisService redisService;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode}")
    private Long REDIS_KEY_EXPIRE_AUTH_CODE;


    /**
     * 根据电话号码，生成验证码
     *
     * @param telephone 电话号码
     * @return 验证码
     */
    @Override
    public CommonResult<String> generateAuthCode(String telephone) {
        if (StringUtils.isBlank(telephone)) {
            return CommonResult.failed("手机号为空，无法生成验证码");
        }
        // 首先效验此手机号是否已经获取没有过期的验证码
        CommonResult<Object> telephoneNumExists = verifyTelephoneNumExists(telephone);
        if (!telephoneNumExists.isSuccess()) {
            return CommonResult.failed("此手机号已经获取过验证码了，请稍后再试");
        }
        // 生产验证码
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        // 验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, stringBuilder.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, REDIS_KEY_EXPIRE_AUTH_CODE);
        return CommonResult.success(stringBuilder.toString(), "获取验证码成功");
    }

    /**
     * 效验验证码是否正确
     *
     * @param telephone 电话号码
     * @param authCode  验证码
     * @return 是否正确结果
     */
    @Override
    public CommonResult<Object> verifyAuthCode(String telephone, String authCode) {
        if (StringUtils.isBlank(authCode)) {
            return CommonResult.failed("请输入验证码");
        }
        String realAuthCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        if (Objects.equals(authCode, realAuthCode)) {
            return CommonResult.success("验证码效验成功");
        }
        return CommonResult.failed("验证码效验失败");
    }

    /**
     * 效验手机号是否已经获取了验证码
     *
     * @param telephone 手机号
     * @return 手机号是否已经存在
     */
    @Override
    public CommonResult<Object> verifyTelephoneNumExists(String telephone) {
        if (StringUtils.isBlank(telephone)) {
            return CommonResult.failed("手机号为空，无法进行手机号验证码是否存在的效验");
        }
        if (redisService.exists(REDIS_KEY_PREFIX_AUTH_CODE + telephone)) {
            return CommonResult.failed("此手机号已经获取过验证码了，请稍后再试");
        }
        return CommonResult.success("此手机号尚未获取验证码，可以获取新的验证码");
    }
}
