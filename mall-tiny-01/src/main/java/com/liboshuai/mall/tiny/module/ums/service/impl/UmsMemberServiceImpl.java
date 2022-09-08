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
    private UmsMemberMapper umsMemberMapper;


    /**
     * 根据用户名称查询用户id
     */
    @Override
    public Long findUserIdByUserName(String userName) {
        LambdaQueryWrapper<UmsMember> umsMemberLambdaQueryWrapper = new LambdaQueryWrapper<>();
        umsMemberLambdaQueryWrapper.eq(UmsMember::getUsername, userName);
        return umsMemberMapper.selectOne(umsMemberLambdaQueryWrapper).getId();
    }
}
