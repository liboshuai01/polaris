package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_app3.d7_innerclass;

/**
 * @author:Sun
 * @date06/12/202212:26 AM
 */
public class Test {

    static {
        class Dog{

        }
        abstract class Animal{

        }

    }

    public static void main(String[] args) {

        class Cat{
            private String name;
            public int onLineNumber = 100;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

        }

    }

}
