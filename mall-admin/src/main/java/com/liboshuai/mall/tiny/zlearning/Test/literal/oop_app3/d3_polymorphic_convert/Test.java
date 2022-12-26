package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_app3.d3_polymorphic_convert;

/**
 * @author:Sun
 * @date05/12/202210:38 PM
 */
public class Test {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.run();

        Dog d = (Dog) a;
        d.lookDoor();
        if(a instanceof Tortoise){
            Tortoise t = (Tortoise) a;
            t.layEggs();
        }else if(a instanceof Dog){
            Dog d1 = (Dog) a;
            d1.lookDoor();
        }

        System.out.println("---------------------");

        Animal a1 = new Dog();
        go(a1);




    }


    public static void go(Animal animal){
        System.out.println("预备~~~");
        animal.run();
        //独有功能
        if (animal instanceof Tortoise){
            Tortoise t = (Tortoise) animal;
            t.layEggs();
        } else if (animal instanceof Dog) {
            Dog d1 = (Dog) animal;
            d1.lookDoor();

        }
        System.out.println("结束~~~~");
    }
}
