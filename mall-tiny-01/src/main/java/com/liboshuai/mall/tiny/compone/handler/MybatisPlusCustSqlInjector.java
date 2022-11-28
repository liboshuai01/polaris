package com.liboshuai.mall.tiny.compone.handler;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.liboshuai.mall.tiny.utils.mybatisPlus.InsertBatchMethod;
import com.liboshuai.mall.tiny.utils.mybatisPlus.UpdateBatchByIdsMethod;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-11-28 13:58
 * @Description: mybatisPlus自定义sql注入器
 */
@Component
public class MybatisPlusCustSqlInjector extends DefaultSqlInjector {
    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        methodList.add(new InsertBatchMethod());
        methodList.add(new UpdateBatchByIdsMethod());
        return methodList;
    }
}