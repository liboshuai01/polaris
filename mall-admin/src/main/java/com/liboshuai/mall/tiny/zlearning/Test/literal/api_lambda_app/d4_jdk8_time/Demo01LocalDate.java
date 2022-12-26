package com.liboshuai.mall.tiny.zlearning.Test.literal.api_lambda_app.d4_jdk8_time;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author:Sun
 * @date06/12/20228:18 PM
 */
public class Demo01LocalDate {
    public static void main(String[] args) {

        LocalDate nowDate = LocalDate.now();
        System.out.println("今天的日期：" + nowDate);

        int year = nowDate.getYear();
        System.out.println("year：" + year);

        int month = nowDate.getMonthValue();
        System.out.println("month:"+month);

        int day = nowDate.getDayOfMonth();
        System.out.println("day:"+day);


        //-------------------------------------------------



        int dayOfYear = nowDate.getDayOfYear();
        System.out.println("dayOfYear:" + dayOfYear);


        System.out.println(nowDate.getDayOfWeek());
        System.out.println(nowDate.getDayOfWeek().getValue());

        System.out.println(nowDate.getMonth());
        System.out.println(nowDate.getMonth().getValue());

        //----------------------------------------------
        LocalDate bt = LocalDate.of(1991,11,11);
        System.out.println(bt);
        System.out.println(LocalDate.of(1991, Month.NOVEMBER,11));




    }
}
