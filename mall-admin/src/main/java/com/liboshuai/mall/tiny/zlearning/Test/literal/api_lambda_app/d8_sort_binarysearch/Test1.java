package com.liboshuai.mall.tiny.zlearning.Test.literal.api_lambda_app.d8_sort_binarysearch;

import java.util.Arrays;

/**
 * @author:Sun
 * @date06/12/202210:38 PM
 */
public class Test1 {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 2};

        for (int i = 0; i < arr.length-1; i++){

            for (int j = i + 1; j < arr.length; j++){
                if (arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
