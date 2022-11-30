package com.liboshuai.mall.tiny.zlearning.Test.literal.methodapp;

/**
 * @author:Sun
 * @date30/11/20221:38 PM
 */
public class Demo07 {
    public static void main(String[] args) {
        int[] ages = {23,19,25,78,34};
        int max = getArrayMaxData(ages);
        System.out.println("最大值是"+max);

        System.out.println("---------------");
        int[] ages1 = {31,21,99,78,34};
        int max1 = getArrayMaxData(ages1);
        System.out.println("最大值是："+max1);

    }
    public static int getArrayMaxData(int[] arr){
        int max = arr[0];
        for (int i = 0;i < arr.length; i++){
            if (max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
}
