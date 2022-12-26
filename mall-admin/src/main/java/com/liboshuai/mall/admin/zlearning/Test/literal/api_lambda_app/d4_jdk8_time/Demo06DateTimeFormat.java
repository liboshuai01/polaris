package com.liboshuai.mall.admin.zlearning.Test.literal.api_lambda_app.d4_jdk8_time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author:Sun
 * @date06/12/20228:19 PM
 */
public class Demo06DateTimeFormat {
    public static void main(String[] args) {

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss EEE a");
        // 正向格式化
        System.out.println(dtf.format(ldt));
        // 逆向格式化
        System.out.println(ldt.format(dtf));

        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        LocalDateTime ldt1 = LocalDateTime.parse("2019-11-11 11:11:11" ,  dtf1);

        System.out.println(ldt);
        System.out.println(ldt1.getDayOfYear());


    }
}
