package com.liboshuai.mall.admin.zlearning.Test.literal.oop_app3.d2_polymorphic_advantage;

/**
 * @author:Sun
 * @date05/12/202210:38 PM
 */
public class Dog extends Animal {
    public String name = "狗名称";
    @Override
    public void run(){
        System.out.println("🐕跑的贼溜~~~~~");
    }


    //独有功能
    public void lookDoor(){
        System.out.println("🐕在看🚪！！！");
    }
}
