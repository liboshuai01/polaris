package com.liboshuai.polaris.common.mybatisPlus;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusAutoConfiguration;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author baobao
 * @create 2021-09-09 14:50
 * @description 自动填充器，填充创建、修改时间和用户
 */
@Component
@ConditionalOnClass(MybatisPlusAutoConfiguration.class)
public class MybatisPlusMetaObjectHandler implements MetaObjectHandler {
    private static final String CREATE_TIME_PROPERTY_NAME = "createTime";
    private static final String UPDATE_TIME_PROPERTY_NAME = "updateTime";
    private static final String CREATE_BY_PROPERTY_NAME = "createUser";
    private static final String UPDATE_BY_PROPERTY_NAME = "updateUser";

    @Override
    public void insertFill(MetaObject metaObject) {
        Date now = new Date();
        // 插入时自动填充createTime和updateTime
        // 判断实体类是否有createTime属性
        if(metaObject.hasSetter(CREATE_TIME_PROPERTY_NAME)){
            if (this.getFieldValByName(CREATE_TIME_PROPERTY_NAME, metaObject) == null) {
                this.strictInsertFill(metaObject, CREATE_TIME_PROPERTY_NAME, Date.class, now);
            }
        }
        // 判断实体类是否有updateTime属性
        if(metaObject.hasSetter(UPDATE_TIME_PROPERTY_NAME)){
            if (this.getFieldValByName(UPDATE_TIME_PROPERTY_NAME, metaObject) == null) {
                this.strictInsertFill(metaObject, UPDATE_TIME_PROPERTY_NAME, Date.class, now);
            }
        }
        // 判断实体类是否有createUser属性
        if(metaObject.hasSetter(CREATE_BY_PROPERTY_NAME)){
            if (this.getFieldValByName(CREATE_BY_PROPERTY_NAME, metaObject) == null) {
                // todo: 等待获取登录用户名
                // String userId = UserInfoHolder.getUserInfo() == null ? "" : UserInfoHolder.getUserInfo().getId();
                this.strictInsertFill(metaObject, CREATE_BY_PROPERTY_NAME, String.class, "");
            }
        }
        // 判断实体类是否有updateUser属性
        if(metaObject.hasSetter(UPDATE_BY_PROPERTY_NAME)){
            if (this.getFieldValByName(UPDATE_BY_PROPERTY_NAME, metaObject) == null) {
                // String userId = UserInfoHolder.getUserInfo() == null ? "" : UserInfoHolder.getUserInfo().getId();
                this.strictInsertFill(metaObject, UPDATE_BY_PROPERTY_NAME, String.class, "");
            }
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 更新时自动填充updateTime
        // 判断实体类是否有updateTime属性
        if(metaObject.hasSetter(UPDATE_TIME_PROPERTY_NAME)){
            if (this.getFieldValByName(UPDATE_TIME_PROPERTY_NAME, metaObject) == null) {
                this.strictInsertFill(metaObject, UPDATE_TIME_PROPERTY_NAME, Date.class, new Date());
            }
        }
        // 判断实体类是否有updateUser属性
        if(metaObject.hasSetter(UPDATE_BY_PROPERTY_NAME)){
            if (this.getFieldValByName(UPDATE_BY_PROPERTY_NAME, metaObject) == null) {
                // String userId = UserInfoHolder.getUserInfo() == null ? "" : UserInfoHolder.getUserInfo().getId();
                this.strictInsertFill(metaObject, UPDATE_BY_PROPERTY_NAME, String.class, "");
            }
        }
    }
}
