package com.liboshuai.mall.tiny.utils.forXunHuan;

public class ArrayMax {
    public static void main(String[] args) {

        int [] arr = {1,20,11,33,98,43,4};
        int max = 0;
        for (int i = 0; i<arr.length;i++){

            if(arr[i]>max){
                max = arr[i];
            }

        }
        System.out.println(max);
    }
}
