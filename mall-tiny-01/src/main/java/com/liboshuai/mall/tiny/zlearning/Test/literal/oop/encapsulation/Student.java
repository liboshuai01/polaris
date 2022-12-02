package com.liboshuai.mall.tiny.zlearning.Test.literal.oop.encapsulation;

/**
 * @author:Sun
 * @date02/12/202210:29 PM
 */
public class Student {
    private int age;
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        if (age >= 0 && age <= 200){
            this.age = age;
        }else {
            System.out.println("年龄数据有问题，应该不是人的年龄");
        }
    }
}
