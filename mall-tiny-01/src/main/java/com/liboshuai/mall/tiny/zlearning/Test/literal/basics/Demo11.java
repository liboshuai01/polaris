package com.liboshuai.mall.tiny.zlearning.Test.literal.basics;

/**
 * @author:Sun
 * @date29/11/202211:00 PM
 */
public class Demo11 {
    public static void main(String[] args) {

        int data = 589;


        //个位
        int ge = data % 10;
        System.out.println(ge);

        //十位
        int shi = data / 10 % 10;
        System.out.println(shi);

        //百位
        int bai = data / 100;
        System.out.println(bai);

    }
}
