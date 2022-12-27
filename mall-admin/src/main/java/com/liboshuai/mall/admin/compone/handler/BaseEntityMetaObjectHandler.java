package com.liboshuai.mall.admin.compone.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author: liboshuai
 * @Date: 2022-09-14 18:17
 * @Description: 实现通用DAO类的数据自动填充
 */
@Slf4j
@Component
public class BaseEntityMetaObjectHandler implements MetaObjectHandler {


    @Override
    public void insertFill(MetaObject metaObject) {
        // todo: 待根据当前登录用户做自动填充
        String currentUser = "system";
        if (StringUtils.isNoneBlank(currentUser)) {
            this.setFieldValByName("createUser", currentUser, metaObject);
        }
        this.setFieldValByName("createTime", new Date(), metaObject);
    }


    @Override
    public void updateFill(MetaObject metaObject) {
        // todo: 待根据当前登录用户做自动填充
        String currentUser = "system";
        if (StringUtils.isNoneBlank(currentUser)) {
            this.setFieldValByName("updateUser", currentUser, metaObject);
        }
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
