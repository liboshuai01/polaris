package com.liboshuai.mall.admin.zlearning.Test.literal.methodapp;


/**
 * @author:Sun
 * @date30/11/20222:13 PM
 */
public class Demo13 {
    public static void main(String[] args) {
        int[] arr = {12,32,23};
        printArray(arr);

        int[] arr2 = {};
        printArray(arr2);

        int[] arr3 = null;
        printArray(arr3);

    }
    public static void printArray(int[] arr){
        if (arr != null){
            System.out.println("[");
            for (int i = 0; i < arr.length; i++){
                if (i == arr.length - 1){
                    System.out.println(arr[i]);
                }else {
                    System.out.println(arr[i]+", ");
                }
                System.out.print(i == arr.length - 1 ? arr[i] :arr[i] + " ,");
            }
            System.out.println("]");
        }else {
            System.out.println("no");
        }
    }
}
