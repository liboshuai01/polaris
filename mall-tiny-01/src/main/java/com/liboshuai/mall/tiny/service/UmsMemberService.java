package com.liboshuai.mall.tiny.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liboshuai.mall.tiny.common.api.CommonResult;
import com.liboshuai.mall.tiny.domain.dao.UmsMember;

/**
 * <p>
 * 会员表 服务类
 * </p>
 *
 * @author liboshuai
 * @since 2022-07-26
 */
public interface UmsMemberService extends IService<UmsMember> {

    /**
     * 生成验证码
     *
     * @param telephone 手机号码
     * @return 验证码信息
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号是否匹配
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
