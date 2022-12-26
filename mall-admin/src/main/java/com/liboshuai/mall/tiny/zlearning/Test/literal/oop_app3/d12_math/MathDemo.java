package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_app3.d12_math;

/**
 * @author:Sun
 * @date06/12/202212:47 PM
 */
public class MathDemo {
    public static void main(String[] args) {
        System.out.println(Math.abs(10));
        System.out.println(Math.abs(-10.3));
        System.out.println(Math.ceil(4.00001));
        System.out.println(Math.ceil(4.0));
        System.out.println(Math.floor(4.99999));
        System.out.println(Math.floor(4.0));

        System.out.println(Math.pow(2, 3));

        System.out.println(Math.round(4.4999));
        System.out.println(Math.round(4.50001));

        System.out.println(Math.random());

        int data = (int)(Math.random() * 7) + 3;
        System.out.println(data);



    }
}
