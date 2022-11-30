package com.liboshuai.mall.tiny.zlearning.Test.literal.methodapp;

/**
 * @author:Sun
 * @date30/11/20222:03 PM
 */
public class Demo12 {
    public static void main(String[] args) {
        int[] arrs = {10,30,20};
        change(arrs);
        System.out.println(arrs[1]);
    }
    public static void change(int[] arrs){
        System.out.println(arrs[1]);
        arrs[1] = 222;
        System.out.println(arrs[1]);
    }
}
