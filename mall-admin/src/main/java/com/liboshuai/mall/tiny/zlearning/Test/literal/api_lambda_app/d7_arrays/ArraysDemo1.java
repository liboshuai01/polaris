package com.liboshuai.mall.tiny.zlearning.Test.literal.api_lambda_app.d7_arrays;

import java.util.Arrays;

/**
 * @author:Sun
 * @date06/12/202210:20 PM
 */
public class ArraysDemo1 {public static void main(String[] args) {
    int[] arr = {10, 2, 55, 23, 24, 100};
    System.out.println(arr);

    System.out.println(Arrays.toString(arr));

    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));

    int index = Arrays.binarySearch(arr,55);
    System.out.println(index);
    int index2 = Arrays.binarySearch(arr, 22);
    System.out.println(index2);


    // 注意：数组如果么有排好序，可能会找不到存在的元素，从而出现bug!!
    int[] arr2 = {12, 36, 34, 25 , 13,  24,  234, 100};
    System.out.println(Arrays.binarySearch(arr2 , 36));

}
}
