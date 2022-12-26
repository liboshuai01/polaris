package com.liboshuai.mall.admin.zlearning.Test.literal.oop_app3.d6_innerclass;

/**
 * @author:Sun
 * @date06/12/202212:16 AM
 */
public class Test {
    public static void main(String[] args) {
        Outer.Inner in = new Outer().new Inner();
        in.setName("内部");
        in.show();

        System.out.println("------------");
        Outer.Inner in1 = new Outer("爱听课").new Inner();
        in1.show();
    }
}
