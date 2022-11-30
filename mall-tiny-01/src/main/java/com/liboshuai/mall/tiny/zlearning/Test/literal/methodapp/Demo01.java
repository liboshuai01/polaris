package com.liboshuai.mall.tiny.zlearning.Test.literal.methodapp;

/**
 * @author:Sun
 * @date30/11/202211:46 AM
 */
public class Demo01 {

    public static void main(String[] args) {
        int c1 = sum(10,20);
        System.out.println(c1);

        int c2 = sum(20,30);
        System.out.println(c2);
    }



    public static int sum(int a,int b){
        int c = a+b;
        return c;
    }
}
