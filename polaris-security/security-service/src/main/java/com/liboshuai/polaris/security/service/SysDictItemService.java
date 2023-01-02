package com.liboshuai.polaris.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liboshuai.polaris.common.domain.ResponseResult;
import com.liboshuai.polaris.security.dto.SysDictItemDTO;
import com.liboshuai.polaris.security.entity.SysDictItemEntity;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 18:22
 * @Description:
 */
public interface SysDictItemService extends IService<SysDictItemEntity> {

    /**
     * 查询每个Dict对应的DictItem的值
     */
    ResponseResult<Map<String, List<SysDictItemDTO>>> queryAllDictItems();
}
