package com.liboshuai.mall.admin.zlearning.Test.literal.methodapp;

/**
 * @author:Sun
 * @date30/11/20221:23 PM
 */
public class Demo04 {
    public static void main(String[] args) {

        System.out.println(sum(10,20));
        print();
        int rs = sum(100,200);
        System.out.println(rs);

        System.out.println(sum(1000,2000));

        sum(3000,5000);
        print();
    }
    public static int sum(int a, int b){
        return a+b;
    }
    public static void print(){
        System.out.println("Hello world");
        System.out.println("Hello world");
        System.out.println("Hello world");
    }
}
