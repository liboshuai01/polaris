package com.liboshuai.mall.admin.zlearning.Test.literal.api_lambda_app.d1_date;

import java.util.Date;

/**
 * @author:Sun
 * @date06/12/20221:15 PM
 */
public class DateDemo1 {
    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d);

        long time = d.getTime();
        System.out.println(time);
        System.out.println("----------------------------");
        Date d1 = new Date();
        System.out.println(d1);

        long time2 = System.currentTimeMillis();
        time2 += (60 * 60 + 121) * 1000;
        System.out.println(time2);
        Date d2 = new Date(time2);
        System.out.println(d2);

        Date d3 = new Date();
        d3.setTime(time2);
        System.out.println(d3);


    }
}
