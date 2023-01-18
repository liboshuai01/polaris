package com.liboshuai.polaris.security.mapper;

import com.liboshuai.polaris.common.domain.RootMapper;
import com.liboshuai.polaris.security.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: liboshuai
 * @Date: 2023-01-17 18:37
 * @Description: 系统日志mapper
 */
@Mapper
public interface SysLogMapper extends RootMapper<SysLogEntity> {
    /**
     * 获取系统总访问次数
     */
    @Select("select count(1) from sys_log where log_type = 1")
    Long findTotalVisitCount();

    /**
     * 获取系统今日访问次数
     */
    @Select("select count(1) from sys_log where log_type = 1 and create_time >= #{dayStart} and create_time < #{dayEnd}")
    Long findTodayVisitCount(@Param("dayStart") Date dayStart, @Param("dayEnd") Date dayEnd);

    /**
     * 获取系统今日访问 IP数
     */
    @Select(" select count(distinct(ip)) from sys_log where log_type = 1 and create_time >= #{dayStart} and create_time < #{dayEnd}")
    Long findTodayIp(@Param("dayStart") Date dayStart, @Param("dayEnd") Date dayEnd);

    /**
     *   首页：根据时间统计访问数量/ip数量
     */
    List<Map<String,Object>> findVisitCount(@Param("dayStart") Date dayStart, @Param("dayEnd") Date dayEnd, @Param("dbType") String dbType);
}
