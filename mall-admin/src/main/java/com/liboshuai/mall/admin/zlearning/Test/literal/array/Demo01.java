package com.liboshuai.mall.admin.zlearning.Test.literal.array;

import java.util.Arrays;

/**
 * @author:Sun
 * @date30/11/202210:25 AM
 */
public class Demo01 {
    public static void main(String[] args) {
        //静态初始化
        double[] scores = {99.5, 88.0, 75.5};//简化写法
        int[] ages = {12,24,36};
        String[] name = {"zs","ls"};
        System.out.println(Arrays.toString(scores));
        System.out.println(Arrays.toString(ages));
        System.out.println(Arrays.toString(name));
    }
}
