package com.liboshuai.mall.admin.zlearning.Test.literal.oop.constructor;

/**
 * @author:Sun
 * @date02/12/20229:13 PM
 */
public class Constructor {
    public static void main(String[] args) {
        Car car = new Car();

        System.out.println(car.name);
        System.out.println(car.price);


        Car car2 = new Car("奔驰GLC",39.11);
        System.out.println(car2.name);
        System.out.println(car2.price);
        }
}
