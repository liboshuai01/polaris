package com.liboshuai.mall.tiny.zlearning.Test.literal.staticuse.d11_extends_constructor;

/**
 * @author:Sun
 * @date04/12/20222:20 PM
 */
public class Test {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("zs",18);
        System.out.println(teacher.getAge());
        System.out.println(teacher.getName());
    }
}
