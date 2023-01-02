package com.liboshuai.polaris.common.annotation;

import java.lang.annotation.*;

/**
 * @Auther: Bernardo
 * @Date: 2023/1/2 19:16
 * @Description: 将枚举类转化成字典数据
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EnumDict {

    /**
     * 作为字典数据的唯一编码
     */
    String value() default "";
}

