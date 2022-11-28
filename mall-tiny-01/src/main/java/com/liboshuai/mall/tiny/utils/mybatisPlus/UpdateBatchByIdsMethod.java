package com.liboshuai.mall.tiny.utils.mybatisPlus;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @Author: liboshuai
 * @Date: 2022-11-28 13:56
 * @Description: 自定义mybatisPlus批量更新方法
 */
@Slf4j
public class UpdateBatchByIdsMethod extends AbstractMethod {
    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        final String sql = "<script>update %s set %s where id in %s</script>";
        final String fieldSql = prepareSetSql(tableInfo);
        final String valueSql = prepareWhereSql();
        final String sqlResult = String.format(sql, tableInfo.getTableName(), fieldSql, valueSql);
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sqlResult, modelClass);
        return this.addUpdateMappedStatement(mapperClass, modelClass, "updateBatchByIds", sqlSource);
    }

    private String prepareSetSql(TableInfo tableInfo) {
        final StringBuilder valueSql = new StringBuilder();
        valueSql.append("<trim suffixOverrides=\",\">");
        for (TableFieldInfo field : tableInfo.getFieldList()) {
            valueSql.append("<if ").append("test = \"entity.").append(field.getProperty()).append(" != null \"").append(">");
            valueSql.append(field.getColumn()).append(" = ").append("#{entity.").append(field.getProperty()).append("},");
            valueSql.append("</if>");
        }
        valueSql.append("</trim>");
        return valueSql.toString();
    }

    private String prepareWhereSql() {
        return "<foreach collection=\"ids\" item=\"id\" index=\"idx\" open=\"(\" close=\")\" separator=\",\">" +
                "        #{id}" +
                "    </foreach>";
    }
}