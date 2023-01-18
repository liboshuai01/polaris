package com.liboshuai.polaris.security.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.liboshuai.polaris.security.entity.SysAnnouncementEntity;
import org.springframework.stereotype.Service;

/**
 * @Author: liboshuai
 * @Date: 2023-01-18 11:09
 * @Description:
 */
public interface SysAnnouncementService extends IService<SysAnnouncementEntity> {
    /**
     * 分页查询系统通告
     */
    Page<SysAnnouncementEntity> querySysCementPageByUserId(Page<SysAnnouncementEntity> page, String userId, String msgCategory);
}
