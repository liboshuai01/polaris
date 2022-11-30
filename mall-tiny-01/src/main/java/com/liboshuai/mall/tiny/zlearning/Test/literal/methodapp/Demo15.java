package com.liboshuai.mall.tiny.zlearning.Test.literal.methodapp;

/**
 * @author:Sun
 * @date30/11/20222:24 PM
 */
public class Demo15 {

    public static void main(String[] args) {

        int[] arr1 = {10,20,30};
        int[] arr2 = {10,20,30};
        System.out.println(compare(arr1,arr2));

        System.out.println("-----------");
        int[] arr3 = null;
        int[] arr4 = {};
        System.out.println(compare(arr3,arr4));
    }
    public static boolean compare(int[] arr1, int[] arr2){
        if (arr1 != null && arr2 != null){
            if (arr1.length == arr2.length){
                for (int i = 0; i < arr1.length;i++){
                    if (arr1[i] != arr2[i]){
                        return false;
                    }
                }
                return true;
            }else {
                return false;
            }
        }else {
            return false;
        }
    }
}
