package com.liboshuai.mall.admin.zlearning.Test.literal.oop_app3.d4_polymorphic_test;

/**
 * @author:Sun
 * @date05/12/202210:59 PM
 */
public class Computer {
    public void installUSB(USB u){
        u.connect();
        if ( u instanceof Mouse){
            Mouse m = (Mouse) u;
            m.click();
        } else if (u instanceof  KeyBoard) {
            KeyBoard k = (KeyBoard) u;
            k.keyDown();
        }

        u.unconnect();
    }
}
