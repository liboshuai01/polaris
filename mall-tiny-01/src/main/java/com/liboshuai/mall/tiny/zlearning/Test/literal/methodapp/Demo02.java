package com.liboshuai.mall.tiny.zlearning.Test.literal.methodapp;

/**
 * @author:Sun
 * @date30/11/20221:15 PM
 */
public class Demo02 {
    public static void main(String[] args) {
        int i = add(100,200);
        System.out.println(i);

        int i1 = add(20,3);
        System.out.println(i1);

    }
    public static int add(int a,int b){
        int c = a+b;
        return c;
    }
}
