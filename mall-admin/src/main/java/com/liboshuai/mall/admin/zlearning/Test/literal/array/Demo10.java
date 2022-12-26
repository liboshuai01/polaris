package com.liboshuai.mall.admin.zlearning.Test.literal.array;

/**
 * @author:Sun
 * @date30/11/202211:17 AM
 */
public class Demo10 {
    public static void main(String[] args) {
        int[] arr = {5,2,3,1};

        for (int i = 0; i<arr.length-1; i++){
            for (int j = 0; j < arr.length - i - 1; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;

                }
            }
        }
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + "\t");

        }


    }
}
