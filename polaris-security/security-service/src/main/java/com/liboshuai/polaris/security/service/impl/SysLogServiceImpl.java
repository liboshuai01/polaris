package com.liboshuai.polaris.security.service.impl;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liboshuai.polaris.common.utils.CommonUtils;
import com.liboshuai.polaris.security.entity.SysLogEntity;
import com.liboshuai.polaris.security.mapper.SysLogMapper;
import com.liboshuai.polaris.security.service.SysLogService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: liboshuai
 * @Date: 2023-01-17 18:36
 * @Description:
 */
@Slf4j
@Service
@NoArgsConstructor
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLogEntity> implements SysLogService {

    private SysLogMapper sysLogMapper;

    @Autowired
    public SysLogServiceImpl(SysLogMapper sysLogMapper) {
        this.sysLogMapper = sysLogMapper;
    }

    /**
     * 获取系统总访问次数
     */
    @Override
    public Long findTotalVisitCount() {
        return sysLogMapper.findTotalVisitCount();
    }

    /**
     * 获取系统今日访问次数
     */
    @Override
    public Long findTodayVisitCount(Date dayStart, Date dayEnd) {
        return sysLogMapper.findTodayVisitCount(dayStart,dayEnd);
    }

    /**
     * 获取系统今日访问 IP数
     */
    @Override
    public Long findTodayIp(Date dayStart, Date dayEnd) {
        return sysLogMapper.findTodayIp(dayStart,dayEnd);
    }

    /**
     * 首页：根据时间统计访问数量/ip数量
     *
     * @param dayStart
     * @param dayEnd
     */
    @Override
    public List<Map<String, Object>> findVisitCount(Date dayStart, Date dayEnd) {
        DbType dbType = CommonUtils.getDatabaseTypeEnum();
        return sysLogMapper.findVisitCount(dayStart, dayEnd,dbType.getDb());
    }
}
