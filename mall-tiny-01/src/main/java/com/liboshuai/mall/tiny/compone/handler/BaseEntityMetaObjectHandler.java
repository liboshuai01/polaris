package com.liboshuai.mall.tiny.compone.handler;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.liboshuai.mall.tiny.utils.ShiroUtil;
import lombok.extern.slf4j.Slf4j;
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

    @Autowired
    private ShiroUtil shiroUtil;

    @Override
    public void insertFill(MetaObject metaObject) {
        String currentUser = shiroUtil.getCurrentUser();
        // todo: 临时日志，待删除
        log.info("insertFill-currentUser为：{}", JSONObject.toJSONString(currentUser));
        this.setFieldValByName("createUser", currentUser, metaObject);
        this.setFieldValByName("createTime", new Date(), metaObject);
    }


    @Override
    public void updateFill(MetaObject metaObject) {
        String currentUser = shiroUtil.getCurrentUser();
        this.setFieldValByName("updateUser", currentUser, metaObject);
        this.setFieldValByName("updateTime", new Date(), metaObject);
    }
}
