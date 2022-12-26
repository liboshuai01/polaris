package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_app3.d1_polymorphic;

/**
 * @author:Sun
 * @date05/12/202210:38 PM
 */
public class Test {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.run();
        System.out.println(animal.name);

        Animal animal1 = new Dog();
        animal1.run();
        System.out.println(animal1.name);
    }
}
