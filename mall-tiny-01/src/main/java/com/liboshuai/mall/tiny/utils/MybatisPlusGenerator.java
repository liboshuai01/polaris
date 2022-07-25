package com.liboshuai.mall.tiny.utils;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author: liboshuai
 * @Date: 2022-07-22 15:32
 * @Description: MybatisPlus代码生成器
 */
public class MybatisPlusGenerator {

    public static void main(String[] args) {
        List<String> tables = new ArrayList<>();
        tables.add("cms_help");
        tables.add("cms_help_category");
        tables.add("cms_member_report");
        tables.add("cms_prefrence_area");
        tables.add("cms_prefrence_area_product_relation");
        // todo: 待将剩余的其他表名添加上

        FastAutoGenerator.create("jdbc:mysql://81.68.182.114:3307/mall","root","intmain()")
                .globalConfig(builder -> {
                    builder.author("liboshuai")               //作者
                            .outputDir("C:\\Users\\李博帅\\IdeaProjects\\mall-tiny\\mall-tiny-01\\src\\main\\java")    //输出路径(写到java目录)
                            .enableSwagger()           //开启swagger
                            .commentDate("yyyy-MM-dd")
                            .fileOverride();            //开启覆盖之前生成的文件

                })
                .packageConfig(builder -> {
                    builder.parent("com.liboshuai")
                            .moduleName("mall.tiny")
                            .entity("domain.dao")
                            .service("service")
                            .serviceImpl("service.impl")
                            .controller("controller")
                            .mapper("mapper")
                            .xml("mapper")
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml,System.getProperty("user.dir")+"\\src\\main\\resources\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables)
                            .addTablePrefix("p_")
                            .serviceBuilder()
                            .formatServiceFileName("%sService")
                            .formatServiceImplFileName("%sServiceImpl")
                            .entityBuilder()
                            .enableLombok()
                            .logicDeleteColumnName("deleted")
                            .enableTableFieldAnnotation()
                            .controllerBuilder()
                            // 映射路径使用连字符格式，而不是驼峰
                            .enableHyphenStyle()
                            .formatFileName("%sController")
                            .enableRestStyle()
                            .mapperBuilder()
                            //生成通用的resultMap
                            .enableBaseResultMap()
                            .superClass(BaseMapper.class)
                            .formatMapperFileName("%sMapper")
                            .enableMapperAnnotation()
                            .formatXmlFileName("%sMapper");
                })
                .templateConfig(new Consumer<TemplateConfig.Builder>() {
                    @Override
                    public void accept(TemplateConfig.Builder builder) {
                        // 实体类使用我们自定义模板
                        builder.entity("templates/myentity.java");
                    }
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();

    }
}
