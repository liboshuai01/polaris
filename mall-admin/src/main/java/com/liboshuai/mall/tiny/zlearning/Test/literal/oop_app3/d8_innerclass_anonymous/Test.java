package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_app3.d8_innerclass_anonymous;

/**
 * @author:Sun
 * @date06/12/202212:05 PM
 */
public class Test {
    public static void main(String[] args) {
        Animal a = new Animal() {
            @Override
            public void run() {
                System.out.println("老虎跑的块~~~");
            }
        };

    }
}

abstract class Animal{
    public abstract void run();
}
