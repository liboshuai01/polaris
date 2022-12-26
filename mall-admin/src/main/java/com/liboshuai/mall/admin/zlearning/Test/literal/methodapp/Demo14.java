package com.liboshuai.mall.admin.zlearning.Test.literal.methodapp;

/**
 * @author:Sun
 * @date30/11/20222:20 PM
 */
public class Demo14 {
    public static void main(String[] args) {

        int[] arr = {11,22,33,4,4,55,6};
        int index = searchIndex(arr,55);
        System.out.println("索引是："+ index);

    }
    public static int searchIndex(int[] arr,int data){

        for (int i = 0; i <arr.length; i++){
            if (arr[i] == data){
                return  i;
            }
        }
        return -1;
    }
}
