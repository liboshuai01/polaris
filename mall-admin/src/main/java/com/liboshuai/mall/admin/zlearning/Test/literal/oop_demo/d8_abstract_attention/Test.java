package com.liboshuai.mall.admin.zlearning.Test.literal.oop_demo.d8_abstract_attention;

/**
 * @author:Sun
 * @date05/12/20229:54 PM
 */
public class Test {
    public static void main(String[] args) {

    }
}
abstract class Card{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

abstract class Cat extends Animal{
    @Override
    public void run(){

    }
}

abstract class Animal{

    public abstract void run();
    public abstract void eat();

}