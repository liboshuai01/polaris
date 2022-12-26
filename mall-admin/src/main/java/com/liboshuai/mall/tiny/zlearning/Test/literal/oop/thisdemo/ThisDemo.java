package com.liboshuai.mall.tiny.zlearning.Test.literal.oop.thisdemo;

/**
 * @author:Sun
 * @date02/12/202211:23 PM
 */
public class ThisDemo {
    public static void main(String[] args) {

        Car car = new Car("宝马",37.11);
        System.out.println(car);
        System.out.println(car.name);
        System.out.println(car.price);

        car.goWith("奔驰");

    }

}
