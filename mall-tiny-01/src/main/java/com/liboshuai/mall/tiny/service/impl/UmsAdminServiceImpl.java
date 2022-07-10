package com.liboshuai.mall.tiny.service.impl;

import com.liboshuai.mall.tiny.domain.dao.UmsAdminDAO;
import com.liboshuai.mall.tiny.mapper.UmsAdminMapper;
import com.liboshuai.mall.tiny.service.UmsAdminService;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Log4j
@NoArgsConstructor
public class UmsAdminServiceImpl implements UmsAdminService {

    private UmsAdminMapper umsAdminMapper;

    @Autowired
    public UmsAdminServiceImpl(UmsAdminMapper umsAdminMapper) {
        this.umsAdminMapper = umsAdminMapper;
    }

    /**
     * 根据 用户名 查询 后台用户信息
     *
     * @param username 用户名
     * @return 后台用户信息
     */
    @Override
    public List<UmsAdminDAO> findAllByUsername(String username) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("username", username);
        return umsAdminMapper.selectByMap(objectMap);
    }
}
