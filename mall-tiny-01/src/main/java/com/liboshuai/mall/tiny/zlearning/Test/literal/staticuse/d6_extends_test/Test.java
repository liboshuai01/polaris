package com.liboshuai.mall.tiny.zlearning.Test.literal.staticuse.d6_extends_test;

/**
 * @author:Sun
 * @date04/12/20221:33 PM
 */
public class Test {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("zs");
        student.setAge(99);
        System.out.println(student.getName());
        System.out.println(student.getAge());
        student.queryCourse();
        student.writeInfo();

    }

}
