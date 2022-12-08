package com.liboshuai.mall.tiny.zlearning.Test.literal.day06.d2_params;

import java.util.Arrays;

/**
 * @author:Sun
 * @date2022/12/822:55
 */
public class MethodDemo {
    public static void main(String[] args) {
        sum();
        sum(10);
        sum(10,20,30);
        sum(new int[]{10,20,30,40,50});
    }
    public static void sum(int...nums){
        System.out.println("元素个数：" + nums.length);
        System.out.println("元素内容：" + Arrays.toString(nums));
    }
}
