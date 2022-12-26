package com.liboshuai.mall.tiny.zlearning.Test.literal.api_lambda_app.d4_jdk8_time;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author:Sun
 * @date06/12/20228:19 PM
 */
public class Demo05Instant {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);

        Instant instant1 = Instant.now();
        System.out.println(instant1.atZone(ZoneId.systemDefault()));

        Date date = Date.from(instant);
        Instant i2 = date.toInstant();
        System.out.println(i2);


    }
}
