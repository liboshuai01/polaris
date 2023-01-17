package com.liboshuai.polaris.security.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liboshuai.polaris.security.entity.SysLogEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: liboshuai
 * @Date: 2023-01-17 18:33
 * @Description: 系统日志服务
 */
public interface SysLogService extends IService<SysLogEntity> {
    /**
     * 获取系统总访问次数
     */
    Long findTotalVisitCount();

    /**
     * 获取系统今日访问次数
     */
    Long findTodayVisitCount(Date dayStart, Date dayEnd);

    /**
     * 获取系统今日访问 IP数
     */
    Long findTodayIp(Date dayStart, Date dayEnd);

    /**
     * 首页：根据时间统计访问数量/ip数量
     */
    List<Map<String,Object>> findVisitCount(Date dayStart, Date dayEnd);
}
