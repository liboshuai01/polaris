package com.liboshuai.polaris.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liboshuai.polaris.common.vo.SysDictItemVO;
import com.liboshuai.polaris.security.entity.SysDictEntity;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 18:18
 * @Description:
 */
public interface SysDictService extends IService<SysDictEntity> {
    Map<String, List<SysDictItemVO>> queryAllDictItems();
}
