package com.liboshuai.mall.admin.zlearning.Test.literal.array;

/**
 * @author:Sun
 * @date30/11/202210:29 AM
 */
public class Demo02 {

    public static void main(String[] args) {

        int[] ages = {12,24,36};

        System.out.println(ages[0]);
        System.out.println(ages[1]);
        System.out.println(ages[2]);

        ages[2] = 100;
        System.out.println(ages[2]);

        //访问数组长度
        System.out.println(ages.length);

        int [] arr = {};
        System.out.println(arr.length-1);
    }
}
