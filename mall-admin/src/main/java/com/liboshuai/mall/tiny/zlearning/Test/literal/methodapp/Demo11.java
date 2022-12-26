package com.liboshuai.mall.tiny.zlearning.Test.literal.methodapp;

/**
 * @author:Sun
 * @date30/11/20222:01 PM
 */
public class Demo11 {
    public static void main(String[] args) {
        int a = 10;
        change(a);
        System.out.println(a);
    }
    public static void change(int a){
        System.out.println(a);
        a = 20;
        System.out.println(a);
    }

}
