package com.liboshuai.mall.tiny.zlearning.Test.literal.day09.d2_recusion;

public class RecursionDemo01 {
    public static void main(String[] args) {
//        test();
        test2();
    }
    public static void test(){
        System.out.println("test");
        test();
    }
    public static void test2(){
        System.out.println("=======test2被执行========");
        test3(); // 方法递归 间接递归
    }
    public static void test3(){
        System.out.println("=======test3被执行========");
        test2();
    }

}
