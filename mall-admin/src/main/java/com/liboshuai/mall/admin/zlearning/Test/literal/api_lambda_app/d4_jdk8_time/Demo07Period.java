package com.liboshuai.mall.admin.zlearning.Test.literal.api_lambda_app.d4_jdk8_time;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author:Sun
 * @date06/12/20228:19 PM
 */
public class Demo07Period {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate birthDate = LocalDate.of(1998, 10, 13);
        System.out.println(birthDate);

        Period period = Period.between(birthDate,today);

        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());

    }
}
