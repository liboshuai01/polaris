package com.liboshuai.mall.tiny.module.ums.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.mall.tiny.common.api.ResponseResult;
import com.liboshuai.mall.tiny.module.ums.domain.dao.UmsMember;
import com.liboshuai.mall.tiny.module.ums.mapper.UmsMemberMapper;
import com.liboshuai.mall.tiny.redis.RedisService;
import com.liboshuai.mall.tiny.module.ums.service.UmsMemberService;
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



    @Autowired
    private RedisService redisService;

    @Autowired
    private UmsMemberMapper umsMemberMapper;

    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;

    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;




    /**
     * 生成验证码
     *
     * @param telephone 手机号码
     * @return 验证码信息
     */
    @Override
    public ResponseResult<String> generateAuthCode(String telephone) {
        // 首先效验验证码是否已经存在
        boolean existsResult = redisService.exists(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        if (existsResult) {
            return ResponseResult.fail("近期已经获取过验证码了，请稍后再试");
        }
        StringBuilder authCode = new StringBuilder();
        Random randomNum = new Random();
        for (int i = 0; i < 6; i++) {
            authCode.append(randomNum.nextInt(10));
        }
        // 验证码绑定手机号并存储到redis
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone, authCode.toString());
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone, AUTH_CODE_EXPIRE_SECONDS);
        return ResponseResult.success("获取验证码成功",authCode.toString());
    }

    /**
     * 判断验证码和手机号是否匹配
     */
    @Override
    public ResponseResult<?> verifyAuthCode(String telephone, String authCodeParam) {
        if (StringUtils.isBlank(authCodeParam)) {
            return ResponseResult.fail("验证码为空");
        }
        String authCode = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        if (Objects.equals(authCode, authCodeParam)) {
            return ResponseResult.success("验证码正确");
        }
        return ResponseResult.success("验证码错误");
    }
}
