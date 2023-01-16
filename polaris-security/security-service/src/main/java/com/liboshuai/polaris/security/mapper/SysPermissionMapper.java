package com.liboshuai.polaris.security.mapper;

import com.liboshuai.polaris.common.domain.RootMapper;
import com.liboshuai.polaris.security.entity.SysPermissionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2023-01-13 17:34
 * @Description:
 */
@Mapper
public interface SysPermissionMapper extends RootMapper<SysPermissionEntity> {
    /**
     * 根据用户查询用户权限
     */
    @Select("SELECT * FROM (\n" +
            "SELECT p.*\n" +
            "FROM  sys_permission p\n" +
            "WHERE (exists(\n" +
            "   select a.id from sys_role_permission a\n" +
            "   join sys_role b on a.role_id = b.id\n" +
            "   join sys_user_role c on c.role_id = b.id\n" +
            "   join sys_user d on d.id = c.user_id\n" +
            "   where p.id = a.permission_id AND d.username = #{username,jdbcType=VARCHAR}\n" +
            " )\n" +
            " or (p.url like '%:code' and p.url like '/online%' and p.hidden = 1)\n" +
            " or (p.url like '%:id' and p.url like '/online%' and p.hidden = 1)\n" +
            " or p.url = '/online')\n" +
            "and p.del_flag = 0\n" +
            "UNION\n" +
            "SELECT p.*\n" +
            "FROM  sys_permission p\n" +
            "WHERE exists(\n" +
            " select a.id from sys_depart_role_permission a\n" +
            " join sys_depart_role b on a.role_id = b.id\n" +
            " join sys_depart_role_user c on c.drole_id = b.id\n" +
            " join sys_user d on d.id = c.user_id\n" +
            " where p.id = a.permission_id AND d.username = #{username,jdbcType=VARCHAR}\n" +
            ")\n" +
            "and p.del_flag = 0\n" +
            ") h order by h.sort_no ASC")
    List<SysPermissionEntity> queryByUser(@Param("username") String username);
}
