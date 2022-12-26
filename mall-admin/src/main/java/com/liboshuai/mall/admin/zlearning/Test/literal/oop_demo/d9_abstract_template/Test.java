package com.liboshuai.mall.admin.zlearning.Test.literal.oop_demo.d9_abstract_template;

/**
 * @author:Sun
 * @date05/12/202210:00 PM
 */
public class Test {
    public static void main(String[] args) {
        StudentMiddle s = new StudentMiddle();
        s.write();

        StudentChild s2 = new StudentChild();
        s2.write();
    }
}
