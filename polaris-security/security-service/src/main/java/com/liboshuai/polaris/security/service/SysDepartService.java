package com.liboshuai.polaris.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liboshuai.polaris.common.domain.ResponseResult;
import com.liboshuai.polaris.security.dto.SysDepartDTO;
import com.liboshuai.polaris.security.entity.SysDepartEntity;

import java.util.List;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 21:31
 * @Description:
 */
public interface SysDepartService extends IService<SysDepartEntity> {

    /**
     * 根据用户id查询机构集合
     */
    ResponseResult<List<SysDepartDTO>> findDepartsByUserId(String userId);
}
