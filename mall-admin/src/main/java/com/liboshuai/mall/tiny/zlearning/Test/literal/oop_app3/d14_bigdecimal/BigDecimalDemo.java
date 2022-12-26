package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_app3.d14_bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author:Sun
 * @date06/12/20221:03 PM
 */
public class BigDecimalDemo {
    public static void main(String[] args) {
        System.out.println(0.09 + 0.01);
        System.out.println(1.0 - 0.32);
        System.out.println(1.015 * 100);
        System.out.println(1.301 / 100);

        System.out.println("-------------------------");

        double a = 0.1;
        double b = 0.2;
        double c = a + b;
        System.out.println(c);
        System.out.println("--------------------------");

        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b1 = BigDecimal.valueOf(b);
        BigDecimal c1 = a1.add(b1);

        System.out.println(c1);

        double rs = c1.doubleValue();
        System.out.println(rs);

        BigDecimal a11 = BigDecimal.valueOf(10.0);
        BigDecimal b11 = BigDecimal.valueOf(3.0);

        BigDecimal c11 = a11.divide(b11, 2, RoundingMode.HALF_UP); // 3.3333333333
        System.out.println(c11);

    }
}
