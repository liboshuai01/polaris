package com.liboshuai.mall.admin.zlearning.Test.literal.oop_demo.d2_modifier.itcast;

import com.liboshuai.mall.admin.zlearning.Test.literal.oop_demo.d2_modifier.Fu;

/**
 * @author:Sun
 * @date05/12/20226:34 PM
 */
public class Zi extends Fu {
    public static void main(String[] args) {
        Zi zi = new Zi();
        zi.protectedMethod();
        zi.publicMethod();

        Fu fu = new Fu();
        fu.publicMethod();
    }
}
