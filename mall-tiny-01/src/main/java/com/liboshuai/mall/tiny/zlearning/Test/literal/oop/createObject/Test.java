package com.liboshuai.mall.tiny.zlearning.Test.literal.oop.createObject;

import org.elasticsearch.common.recycler.Recycler;

/**
 * @author:Sun
 * @date02/12/20229:43 PM
 */
public class Test {
    public static void main(String[] args) {
        Car c1 = new Car();
        System.out.println(c1);
        c1.name = "宝马";
        c1.price = 38.9;
        System.out.println(c1.name);
        System.out.println(c1.price);
        c1.start();
        c1.run();
        System.out.println("=============");

        Car c2 = new Car();
        c2.name = "奔驰";
        c2.price = 39.89;
        System.out.println(c2.name);
        System.out.println(c2.price);
        c2.start();
        c2.run();
    }
}
