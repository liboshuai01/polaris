package com.liboshuai.mall.tiny.zlearning.Test.literal.oop.thisdemo;

/**
 * @author:Sun
 * @date02/12/202211:22 PM
 */
public class Car {
    String name;
    double price;

    public void goWith(String name){
        System.out.println(this.name + "正在和："+name+ "比赛");
    }
    public Car(String name, double price){
        System.out.println("有参构造器执行");
        System.out.println(this);
        this.name = name;
        this.price = price;
    }


}
