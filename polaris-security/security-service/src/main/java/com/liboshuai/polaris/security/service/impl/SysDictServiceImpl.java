package com.liboshuai.polaris.security.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.polaris.security.entity.SysDictEntity;
import com.liboshuai.polaris.security.mapper.SysDictMapper;
import com.liboshuai.polaris.security.service.SysDictService;
import org.springframework.stereotype.Service;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 18:20
 * @Description:
 */
@Service
public class SysDictServiceImpl extends ServiceImpl<SysDictMapper, SysDictEntity> implements SysDictService {
    @Override
    public Object queryAllDictItems() {
        return null;
    }
}
