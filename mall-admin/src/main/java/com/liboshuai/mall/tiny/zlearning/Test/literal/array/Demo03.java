package com.liboshuai.mall.tiny.zlearning.Test.literal.array;

import javax.swing.*;

/**
 * @author:Sun
 * @date30/11/202210:31 AM
 */
public class Demo03 {
    public static void main(String[] args) {
        int [] ages = {11,23,45};
//        String[] names = {"zs","ls","ww"};

//        System.out.println(ages[3]);//超出数组长度

        /*动态初始化数组
        *
        * */
        double [] scores = new double[3];
        scores[0] = 99.5;
        System.out.println(scores[0]);
        System.out.println(scores[2]);
//        System.out.println(scores[3]);

        String[] names = new String[90];

        names[0] = "zs";
        names[1] = "ls";

        System.out.println(names[0]);
        System.out.println(names[1]);
        System.out.println(names[2]);

    }
}
