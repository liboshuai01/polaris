package com.liboshuai.mall.admin.utils;

import cn.hutool.core.io.FileUtil;
import com.liboshuai.mall.admin.common.enums.AutoMysqlEnum;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: liboshuai
 * @Date: 2022-09-17 15:51
 * @Description: 随机生成mysql数据工具类
 */
public class AutoMysqlUtil {
    /**
     * 临时表名
     */
    private static final String TMP_TABLE = "tmp_table";
    /**
     * 生成的表数据文件末尾追加的一行内容
     */
    private static final String FILE_END_FLAG = "文件结尾标识";
    /**
     * 生成的表数据文件地址
     */
    private static final String FILE_ADDRESS = "C:\\Users\\李博帅\\Desktop\\temp\\mallFour.txt";

    public static void main(String[] args) {
        // 刚才下载到本地的mysql表、字段数据文件地址
        List<String> readLines = FileUtil.readLines(FILE_ADDRESS, "UTF-8");
        // 拼接 "INSERT INTO ? SELECT content FROM tmp_table" + tableName 部分
        List<String> tableNameList = readLines.stream()
                .map(readLine -> readLine.split("\\s+")[0])
                .collect(Collectors.toList());
        Map<String, List<String>> tableNameMap = tableNameList.stream().collect(Collectors.groupingBy(String::toString));
        Set<String> tableNameSet = tableNameMap.keySet();
        List<StringBuilder> truncateTableMysqlList = tableNameSet.stream()
                .filter(tableName -> !Objects.equals(tableName, TMP_TABLE) && !tableName.startsWith(FILE_END_FLAG))
                .map(tableName -> new StringBuilder("truncate table ")
                        .append(tableName).append(";"))
                .collect(Collectors.toList());
        List<String> columnNameList = readLines.stream()
                .map(readLine -> readLine.split("\\s+")[1])
                .collect(Collectors.toList());
        List<String> typeList = readLines.stream()
                .map(readLine -> readLine.split("\\s+")[3])
                .collect(Collectors.toList());
        List<StringBuilder> mysqlList = new ArrayList<>();
        String tableName = tableNameList.get(0);
        int flag = 0;
        for (int i = 0; i < tableNameList.size(); i++) {
            String tableNameTemp = tableNameList.get(i);
            boolean equalsOne = Objects.equals(tableNameTemp, tableName);
            boolean equalsThree = Objects.equals(tableNameTemp, TMP_TABLE);
            if (!equalsOne &&!equalsThree) {
                    List<String> columnNameTempList = new ArrayList<>();
                    List<String> typeTempList = new ArrayList<>();
                    for (int j = flag; j < i; j++) {
                        String columnName = columnNameList.get(j);
                        String type = typeList.get(j);
                        columnNameTempList.add(columnName);
                        typeTempList.add(type);
                    }
                    StringBuilder mysql = new StringBuilder()
                            .append("INSERT INTO ").append(tableName)
                            .append(" SELECT ");
                    for (int j = 0; j < columnNameTempList.size(); j++) {
                        String columnName = columnNameTempList.get(j);
                        String type = typeTempList.get(j);
                        if (Objects.equals(columnName, AutoMysqlEnum.ID.getKey())) {
                            mysql.append(AutoMysqlEnum.ID.getValue());
                        } else if (Objects.equals(columnName, AutoMysqlEnum.CREATE_TIME.getKey())) {
                            mysql.append(AutoMysqlEnum.CREATE_TIME.getValue());
                        } else if (Objects.equals(columnName, AutoMysqlEnum.CREATE_USER.getKey())) {
                            mysql.append("CONCAT( '").append(AutoMysqlEnum.CREATE_USER.getValue()).append("', id ), ");
                        } else if (Objects.equals(columnName, AutoMysqlEnum.UPDATE_USER.getKey())) {
                            mysql.append("CONCAT( '").append(AutoMysqlEnum.UPDATE_USER.getValue()).append("', id ), ");
                        } else if (Objects.equals(columnName, AutoMysqlEnum.UPDATE_TIME.getKey())) {
                            mysql.append(AutoMysqlEnum.UPDATE_TIME.getValue());
                        } else {
                            if (type.startsWith(AutoMysqlEnum.BIGINT.getKey())) {
                                mysql.append(AutoMysqlEnum.BIGINT.getValue());
                            } else if (type.startsWith(AutoMysqlEnum.VARCHAR.getKey())
                                    || type.startsWith(AutoMysqlEnum.VARBINARY.getKey())
                                    || type.startsWith(AutoMysqlEnum.TEXT.getKey())) {
                                mysql.append("CONCAT( '").append(columnName).append("', id ), ");
                            } else if (type.startsWith(AutoMysqlEnum.INT1.getKey())) {
                                mysql.append(AutoMysqlEnum.INT1.getValue());
                            } else if (type.startsWith(AutoMysqlEnum.INT2.getKey())) {
                                mysql.append(AutoMysqlEnum.INT2.getValue());
                            } else if (type.startsWith(AutoMysqlEnum.INT.getKey())) {
                                mysql.append(AutoMysqlEnum.INT.getValue());
                            } else if (type.startsWith(AutoMysqlEnum.DECIMAL.getKey())) {
                                mysql.append(AutoMysqlEnum.DECIMAL.getValue());
                            } else if (type.startsWith(AutoMysqlEnum.DATE.getKey())) {
                                mysql.append(AutoMysqlEnum.DATE.getValue());
                            } else if (type.startsWith(AutoMysqlEnum.DATETIME.getKey())) {
                                mysql.append(AutoMysqlEnum.DATETIME.getValue());
                            } else if (type.startsWith(AutoMysqlEnum.TIME.getKey())) {
                                mysql.append(AutoMysqlEnum.TIME.getValue());
                            } else if (type.startsWith(AutoMysqlEnum.CHAR.getKey())) {
                                mysql.append(AutoMysqlEnum.CHAR.getValue());
                            }
                        }
                    }
                    mysqlList.add(mysql);
                    tableName = tableNameList.get(i);
                    flag = i;
            }
        }
        mysqlList = mysqlList.stream()
                .map(mysql -> mysql.substring(0, mysql.length() - 2))
                .map(mysql -> new StringBuilder(mysql).append(" FROM tmp_table;"))
                .collect(Collectors.toList());
        truncateTableMysqlList.addAll(mysqlList);
        // mysql文件生成的地址
        FileUtil.writeLines(truncateTableMysqlList, "C:\\Users\\李博帅\\Desktop\\temp\\mallMysql.sql", "UTF-8");
    }
}
