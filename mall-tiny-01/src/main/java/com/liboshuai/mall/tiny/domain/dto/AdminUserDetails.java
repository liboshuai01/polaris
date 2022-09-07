package com.liboshuai.mall.tiny.domain.dto;

import com.liboshuai.mall.tiny.domain.dao.UmsAdmin;
import com.liboshuai.mall.tiny.domain.dao.UmsPermission;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-07-22 15:19
 * @Description:
 */
public class AdminUserDetails {

    private UmsAdmin umsAdmin;

    private List<UmsPermission> permissionList;

    public AdminUserDetails(UmsAdmin umsAdmin, List<UmsPermission> permissionList) {
        this.umsAdmin = umsAdmin;
        this.permissionList = permissionList;
    }

}
