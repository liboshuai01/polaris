package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_app3.d4_polymorphic_test;

/**
 * @author:Sun
 * @date05/12/202211:00 PM
 */
public class Test {
    public static void main(String[] args) {
        Computer c = new Computer();
        USB u  = new Mouse("罗技");
        c.installUSB(u);
        USB k = new KeyBoard("IKBC");
        c.installUSB(k);

    }
}
