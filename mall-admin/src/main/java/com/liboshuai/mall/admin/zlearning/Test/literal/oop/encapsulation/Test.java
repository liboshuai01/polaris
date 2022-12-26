package com.liboshuai.mall.admin.zlearning.Test.literal.oop.encapsulation;

/**
 * @author:Sun
 * @date02/12/202210:30 PM
 */
public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(-23);
        System.out.println(student.getAge());
    }
}
