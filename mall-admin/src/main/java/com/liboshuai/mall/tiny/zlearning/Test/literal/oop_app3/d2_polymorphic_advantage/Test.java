package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_app3.d2_polymorphic_advantage;

/**
 * @author:Sun
 * @date05/12/202210:38 PM
 */
public class Test {
    public static void main(String[] args) {
        Animal animal = new Dog();
        go(animal);

        Animal t = new Tortoise();
        go(t);






    }


    public static void go(Animal animal){
        System.out.println("预备~~~");
        animal.run();
        System.out.println("结束~~~~");
    }
}
