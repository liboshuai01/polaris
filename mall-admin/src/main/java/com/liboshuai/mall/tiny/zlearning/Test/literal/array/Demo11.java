package com.liboshuai.mall.tiny.zlearning.Test.literal.array;

/**
 * @author:Sun
 * @date30/11/202211:24 AM
 */
public class Demo11 {
    public static void main(String[] args) {
        int[] arr1 = {10, 20,30};
        int[] arr2 = {10,20,31};
        if (arr1 == arr2){
            System.out.println("=");
        }
        else{
            if (arr1.length == arr2.length){
                boolean flag = true;
                for (int i = 0; i < arr1.length; i++){
                    if (arr1[i] != arr2[i]){
                        System.out.println("!=");
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    System.out.println("=");
                }
            }else {
                System.out.println("!=");
            }

        }
    }
}
