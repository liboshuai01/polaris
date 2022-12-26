package com.liboshuai.mall.tiny.zlearning.Test.literal.staticuse.d11_extends_constructor;

/**
 * @author:Sun
 * @date04/12/20222:20 PM
 */
public class People {
    private String name;
    private int age;


    public People(){

    }
    public People(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
