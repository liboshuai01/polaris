package com.liboshuai.polaris.security.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.polaris.security.entity.SysAnnouncementEntity;
import com.liboshuai.polaris.security.mapper.SysAnnouncementMapper;
import com.liboshuai.polaris.security.service.SysAnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: liboshuai
 * @Date: 2023-01-18 11:10
 * @Description:
 */
@Service
public class SysAnnouncementServiceImpl extends ServiceImpl<SysAnnouncementMapper, SysAnnouncementEntity> implements SysAnnouncementService {

    private SysAnnouncementMapper sysAnnouncementMapper;

    @Autowired
    public SysAnnouncementServiceImpl(SysAnnouncementMapper sysAnnouncementMapper) {
        this.sysAnnouncementMapper = sysAnnouncementMapper;
    }

    /**
     * 分页查询系统通告
     */
    @Override
    public Page<SysAnnouncementEntity> querySysCementPageByUserId(Page<SysAnnouncementEntity> page, String userId, String msgCategory) {
        if (page.getSize() == -1) {
            return page.setRecords(sysAnnouncementMapper.querySysCementListByUserId(null, userId, msgCategory));
        } else {
            return page.setRecords(sysAnnouncementMapper.querySysCementListByUserId(page, userId, msgCategory));
        }
    }
}
