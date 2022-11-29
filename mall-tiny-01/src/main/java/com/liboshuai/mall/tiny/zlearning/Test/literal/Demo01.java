package com.liboshuai.mall.tiny.zlearning.Test.literal;

/**
 * @author:Sun
 * @date29/11/202210:12 PM
 */
public class Demo01 {

    public static void main(String[] args) {
        int age = 21;
        age =25;
        System.out.println(age);
        {
            double money = 23.5;
            System.out.println(money);
//            double money = 10.0;
//            int age = 28;

        }
//        System.out.println(money);
        System.out.println(age);
        double money = 23.5;
        System.out.println(money);

        int number;
        number =100;
        System.out.println(number);


        System.out.println("--------数据底层原理----------");
        char ch = 'a';
        System.out.println(ch+1);
        System.out.println(ch);

        int i1 = 0b01000110;
        System.out.println(i1);

        int i2 = 0140;
        System.out.println(i2);

        int i3 = 0x61;
        System.out.println(i3);
    }
}
