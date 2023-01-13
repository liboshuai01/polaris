package com.liboshuai.polaris.security.mapper;

import com.liboshuai.polaris.common.domain.RootMapper;
import com.liboshuai.polaris.security.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2023-01-13 16:29
 * @Description: 用户角色mapper
 */
@Mapper
public interface SysUserRoleMapper extends RootMapper<SysUserRoleEntity> {

    /**
     * 通过用户账号查询角色集合
     * @param username 用户账号名称
     * @return List<String>
     */
    @Select("select role_code from sys_role where id in (select role_id from sys_user_role where user_id = (select id from sys_user where username=#{username}))")
    List<String> getRoleByUserName(@Param("username") String username);
}
