package com.liboshuai.mall.admin.zlearning.Test.literal.oop.constructor;

/**
 * @author:Sun
 * @date02/12/20229:16 PM
 */
public class Car {
    String name;
    double price;

    public Car(){
        System.out.println("无参构造器触发被执行");
    }
    public Car(String n,double p){
        System.out.println("有参构造器被执行");
        name = n;
        price = p;
    }
}
