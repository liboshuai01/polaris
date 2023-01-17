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
    @Select("<if test=\"dbType == 'mysql' || dbType == 'mariadb'  || dbType == 'clickhouse'|| dbType == 'sqlite'\">\n" +
            "    select count(*) as visit\n" +
            "        ,count(distinct(ip)) as ip\n" +
            "        ,DATE_FORMAT(create_time, '%Y-%m-%d') as tian\n" +
            "        ,DATE_FORMAT(create_time, '%m-%d') as type\n" +
            "        from sys_log \n" +
            "    where log_type = 1 and create_time >= #{dayStart} and create_time < #{dayEnd}\n" +
            "    group by tian,type\n" +
            "    order by tian asc\n" +
            "  </if>\n" +
            "  <if test=\"dbType == 'oracle' || dbType == 'oracle12c' || dbType == 'dm'\">\n" +
            "  select count(*) as visit\n" +
            "        ,count(distinct(ip)) as ip\n" +
            "        ,to_char(create_time, 'yyyy-mm-dd') as tian\n" +
            "        ,to_char(create_time, 'mm-dd') as type\n" +
            "    from sys_log \n" +
            "    where log_type = 1 and create_time >= #{dayStart} and create_time < #{dayEnd}\n" +
            "    group by to_char(create_time, 'yyyy-mm-dd'),to_char(create_time, 'mm-dd') \n" +
            "    order by to_char(create_time, 'yyyy-mm-dd') asc\n" +
            "  </if>\n" +
            "<if test=\"dbType == 'postgresql' || dbType == 'kingbasees' || dbType == 'zenith'\">\n" +
            "  select count(*) as visit\n" +
            "        ,count(distinct(ip)) as ip\n" +
            "        ,to_char(create_time, 'yyyy-mm-dd') as tian\n" +
            "        ,to_char(create_time, 'mm-dd') as type\n" +
            "    from sys_log \n" +
            "    where log_type = 1 and create_time >= #{dayStart} and create_time < #{dayEnd}\n" +
            "    group by tian,type \n" +
            "    order by tian asc \t   \n" +
            "</if>\n" +
            "<if test=\"dbType == 'sqlserver' || dbType == 'sqlserver2005'\">\n" +
            "  select count(*) as visit\n" +
            "        ,count(distinct(ip)) as ip\n" +
            "          ,CONVERT(varchar(100), create_time, 23) as tian\n" +
            "        ,RIGHT(CONVERT(varchar(100), create_time, 23),5) as type\n" +
            "    from sys_log \n" +
            "    where log_type = 1 and create_time >= #{dayStart} and create_time < #{dayEnd} \n" +
            "    group by CONVERT(varchar(100), create_time, 23),RIGHT(CONVERT(varchar(100), create_time, 23),5)  \n" +
            "    order by CONVERT(varchar(100), create_time, 23) asc\t  \n" +
            "</if>")
    List<Map<String,Object>> findVisitCount(@Param("dayStart") Date dayStart, @Param("dayEnd") Date dayEnd, @Param("dbType") String dbType);
}
