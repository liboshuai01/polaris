package com.liboshuai.mall.tiny.zlearning.Test.literal.array;

import freemarker.core.JSONOutputFormat;

/**
 * @author:Sun
 * @date30/11/202210:41 AM
 */
public class Demo04 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.println(arr[0]);
        System.out.println(arr[9]);

        char[] chars = new  char[100];
        System.out.println((int)chars[0]);
        System.out.println((int)chars[99]);

        double[] scores = new double[90];
        System.out.println(scores[0]);
        System.out.println(scores[89]);

        boolean[] booleans = new boolean[100];
        System.out.println(booleans[0]);
        System.out.println(booleans[99]);

        String[] names = new String[90];
        System.out.println(names[0]);
        System.out.println(names[89]);

        int[] a = {1,2,3};
        int[] b = {1,2,3};
        System.out.println(a);
        System.out.println(b);


    }
}
