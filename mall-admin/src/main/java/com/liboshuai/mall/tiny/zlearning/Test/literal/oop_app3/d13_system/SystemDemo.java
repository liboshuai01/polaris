package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_app3.d13_system;

import java.util.Arrays;

/**
 * @author:Sun
 * @date06/12/202212:56 PM
 */
public class SystemDemo {
    public static void main(String[] args) {
        System.out.println("程序开始。。。");

        long time = System.currentTimeMillis();
        System.out.println(time);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 100000; i++){
            System.out.println("输出:"+i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println((endTime - startTime)/1000.0 + "s");



        int[] arr1 = {10, 20, 30, 40, 50, 60, 70};
        int[] arr2 = new int[6];
        System.arraycopy(arr1,3,arr2,2,3);
        System.out.println(Arrays.toString(arr2));

        System.out.println("-----------------------");
        double i = 10.0;
        double j = 3.0;

        System.out.println("程序结束。。。。");

    }
}
