package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_demo.d13_interface_jdk8;

/**
 * @author:Sun
 * @date05/12/202210:20 PM
 */
public interface SportMan {
    default void run(){
//        go();
        System.out.println("==跑的贼溜==");
    }

    static void inAddr(){
        System.out.println("我们在黑马");
    }
//    private void go(){
//        System.out.println("开始跑");
//    }
}
