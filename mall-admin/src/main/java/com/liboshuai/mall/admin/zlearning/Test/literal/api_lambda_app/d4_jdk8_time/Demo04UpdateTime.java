package com.liboshuai.mall.admin.zlearning.Test.literal.api_lambda_app.d4_jdk8_time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.MonthDay;

/**
 * @author:Sun
 * @date06/12/20228:19 PM
 */
public class Demo04UpdateTime {
    public static void main(String[] args) {
        LocalTime nowTime = LocalTime.now();
        System.out.println(nowTime);
        System.out.println(nowTime.minusHours(1));
        System.out.println(nowTime.minusMinutes(1));
        System.out.println(nowTime.minusSeconds(1));
        System.out.println(nowTime.minusNanos(1));

        //--------------------------------

        System.out.println(nowTime.plusHours(1));
        System.out.println(nowTime.plusMinutes(1));
        System.out.println(nowTime.plusSeconds(1));
        System.out.println(nowTime.plusNanos(1));

        //---------------------------------

        System.out.println(nowTime);


        LocalDate myDate = LocalDate.of(2018, 9, 5);
        LocalDate nowDate = LocalDate.now();

        System.out.println("今天是2018-09-06吗？ " + nowDate.equals(myDate));

        System.out.println("今天是2018-09-06吗？ " + nowDate.equals(myDate));//今天是2018-09-06吗？ false
        System.out.println(myDate + "是否在" + nowDate + "之前？ " + myDate.isBefore(nowDate));//2018-09-05是否在2018-09-06之前？ true
        System.out.println(myDate + "是否在" + nowDate + "之后？ " + myDate.isAfter(nowDate));//2018-09-05是否在2018-09-06之后？ false

        //=================
        LocalDate birDate = LocalDate.of(1996, 8, 5);
        LocalDate nowDate1 = LocalDate.now();

        MonthDay birMd = MonthDay.of(birDate.getMonthValue(), birDate.getDayOfMonth());
        MonthDay nowMd = MonthDay.from(nowDate1);

        System.out.println("今天是你的生日吗？ " + birMd.equals(nowMd));//今天是你的生日吗？ false
    }
}
