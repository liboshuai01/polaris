package com.liboshuai.mall.admin.zlearning.Test.literal.staticuse.d12_this;

/**
 * @author:Sun
 * @date04/12/20222:25 PM
 */
public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("殷素素","冰火岛自学");
        System.out.println(s1.getName());
        System.out.println(s1.getSchoolName());

        Student s2 = new Student("zs");
        System.out.println(s2.getName());
        System.out.println(s2.getSchoolName());
    }
}
