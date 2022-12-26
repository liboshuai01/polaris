package com.liboshuai.mall.tiny.zlearning.Test.literal.methodapp;

/**
 * @author:Sun
 * @date30/11/20221:47 PM
 */
public class Demo08 {
    public static void main(String[] args) {
        study();
    }
    public static void eat(){
        System.out.println("吃饭");
    }
    public static void sleep(){
        System.out.println("睡觉");
    }
    public static void study(){
        eat();
        System.out.println("学习");
        sleep();
    }
}
