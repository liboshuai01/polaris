package com.liboshuai.mall.tiny.zlearning.Test.literal.oop.memory;

/**
 * @author:Sun
 * @date02/12/202210:51 PM
 */
public class Test {
    public static void main(String[] args) {
        Student student =new Student();
        student.name = "ZS";
        student.sex = '男';
        student.hobby = "睡觉";
        student.study();

        Student student1 = student;
        System.out.println(student);
        System.out.println(student1);

        student1.hobby = "打游戏";
        System.out.println(student1.name);
        System.out.println(student1.sex);
        System.out.println(student1.hobby);
        student1.study();

        student = null;
        student1 = null;
//        System.out.println(student.name);
    }
}
