package com.liboshuai.mall.tiny.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.tiny.common.api.CommonResult;
import com.liboshuai.mall.tiny.domain.dao.UmsMember;
import com.liboshuai.mall.tiny.mapper.UmsMemberMapper;
import com.liboshuai.mall.tiny.redis.RedisService;
import com.liboshuai.mall.tiny.service.UmsMemberService;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Random;

/**
 * <p>
 * 会员表 服务实现类
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
@Service
public class UmsMemberServiceImpl extends ServiceImpl<UmsMemberMapper, UmsMember> implements UmsMemberService {

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    private final RedisService redisService;

    @Autowired
    public UmsMemberServiceImpl(RedisService redisService) {
        this.redisService = redisService;
    }

    /**
     * 生成验证码
     *
     * @param telephone 手机号码
     * @return 验证码信息
     */
    @Override
    public CommonResult generateAuthCode(String telephone) {
        // 首先效验验证码是否已经存在
        boolean existsResult = redisService.exists(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        if (existsResult) {
            return CommonResult.failed("近期已经获取过验证码了，请稍后再试");
        }
        StringBuilder authCode = new StringBuilder();
        Random randomNum = new Random();
        for (int i = 0; i < 6; i++) {
            authCode.append(randomNum.nextInt(10));
        }
        // 验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, authCode.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        return CommonResult.success(authCode.toString(), "获取验证码成功");
    }

    /**
     * 判断验证码和手机号是否匹配
     */
    @Override
    public CommonResult verifyAuthCode(String telephone, String authCodeParam) {
        if (StringUtils.isBlank(authCodeParam)) {
            return CommonResult.failed("验证码为空");
        }
        String authCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        if (Objects.equals(authCode, authCodeParam)) {
            return CommonResult.success("验证码正确");
        }
        return CommonResult.success("验证码错误");
    }

}
