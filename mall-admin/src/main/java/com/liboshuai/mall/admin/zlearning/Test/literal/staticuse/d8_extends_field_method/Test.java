package com.liboshuai.mall.admin.zlearning.Test.literal.staticuse.d8_extends_field_method;

/**
 * @author:Sun
 * @date04/12/20221:53 PM
 */
public class Test {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.run();
        d.lookDoor();
        d.showName();

    }
}

class Animal{
    public String name = "动物名";

    public void run(){
        System.out.println("动物可以跑~~");
    }

}
class Dog extends Animal{
    public String name = "狗名";
    public void lookDoor(){
        System.out.println("狗可以看门");
    }

    public void showName(){
        String name = "局部名";
        System.out.println(name);
        System.out.println(this.name);
        System.out.println(super.name);

        super.run();
        run();
    }
}
