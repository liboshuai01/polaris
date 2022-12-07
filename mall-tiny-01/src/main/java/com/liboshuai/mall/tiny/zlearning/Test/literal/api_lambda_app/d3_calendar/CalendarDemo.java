package com.liboshuai.mall.tiny.zlearning.Test.literal.api_lambda_app.d3_calendar;

import java.util.Calendar;
import java.util.Date;

/**
 * @author:Sun
 * @date06/12/20228:12 PM
 */
public class CalendarDemo {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal);

        int year = cal.get(Calendar.YEAR);
        System.out.println(year);

        int mm = cal.get(Calendar.MARCH);
        System.out.println(mm);

        int days = cal.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);

        cal.add(Calendar.DAY_OF_YEAR,64);
        cal.add(Calendar.MINUTE,59);

        Date d = cal.getTime();
        System.out.println(d);


        long time = cal.getTimeInMillis();
        System.out.println(time);

    }
}
