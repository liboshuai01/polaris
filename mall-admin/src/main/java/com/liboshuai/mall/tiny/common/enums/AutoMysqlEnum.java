package com.liboshuai.mall.tiny.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author: liboshuai
 * @Date: 2022-09-17 18:51
 * @Description: 自动生成mysql
 */
@Getter
@AllArgsConstructor
@SuppressWarnings("AlibabaEnumConstantsMustHaveComment")
public enum AutoMysqlEnum {
//    [date, int(2), int(1), varchar(128), varchar(8), char(1), int(11), varchar(16), varchar(32), bigint(11), varchar(50), datetime, bigint(20), varchar(64), varbinary(500), time, decimal(10,2), text, varchar(1000), varchar(100), varchar(255), varchar(200), int(3), varchar(500)]

    // 按照类型
    BIGINT("bigint", "FLOOR( Rand() * 100000), "),
    INT1("int(1)", "FLOOR(0 +  Rand() * 2), "),
    INT2("int(2)", "FLOOR( Rand() * 100), "),
    INT("int", "FLOOR( Rand() * 10000), "),
    DECIMAL("decimal", "FLOOR( Rand() * 100000), "),
    DATE("date", "ADDDATE(ADDDATE(ADDDATE('2018-01-01', INTERVAL FLOOR(RAND() * 8) YEAR),INTERVAL FLOOR(RAND() * 12) MONTH),INTERVAL FLOOR(RAND() * 31) DAY), "),
    DATETIME("datetime", "ADDDATE(ADDDATE(ADDDATE(ADDDATE(ADDDATE(ADDDATE('2018-01-01 00:00:00', INTERVAL FLOOR(RAND() * 8) YEAR),INTERVAL FLOOR(RAND() * 12) MONTH),INTERVAL FLOOR(RAND() * 31) DAY), INTERVAL FLOOR(RAND() * 24) HOUR),INTERVAL FLOOR(RAND() * 60) MINUTE),INTERVAL FLOOR(RAND() * 60) SECOND), "),
    TIME("time", "'00:00:00', "),
    VARCHAR("varchar", "NULL, "),
    CHAR("char", "'0', "),
    VARBINARY("varbinary", "NULL, "),
    TEXT("text", "NULL, "),

    // 按照列名
    ID("id", "id, "),
    CREATE_TIME("create_time", "ADDDATE(ADDDATE(ADDDATE(ADDDATE(ADDDATE(ADDDATE('2022-09-17 22:00:00', INTERVAL FLOOR(1 -(RAND() * 4)) YEAR),INTERVAL FLOOR(1 - (RAND() * 12)) MONTH),INTERVAL FLOOR(1 - (RAND() * 31)) DAY),INTERVAL FLOOR(1 - (RAND() * 24)) HOUR),INTERVAL FLOOR(1 - RAND() * 60) MINUTE),INTERVAL FLOOR(1 - (RAND() * 60)) SECOND), "),
    CREATE_USER("create_user", "admin"),
    UPDATE_TIME("update_time", "ADDDATE(ADDDATE(ADDDATE(ADDDATE(ADDDATE(ADDDATE('2022-09-17 22:00:00', INTERVAL FLOOR(1 + (RAND() * 4)) YEAR),INTERVAL FLOOR(1 + (RAND() * 12)) MONTH),INTERVAL FLOOR(1 + (RAND() * 31)) DAY),INTERVAL FLOOR(1 + (RAND() * 24)) HOUR),INTERVAL FLOOR(1 + RAND() * 60) MINUTE),INTERVAL FLOOR(1 + (RAND() * 60)) SECOND), "),
    UPDATE_USER("update_user", "lbs");


    private String key;
    private String value;

}
