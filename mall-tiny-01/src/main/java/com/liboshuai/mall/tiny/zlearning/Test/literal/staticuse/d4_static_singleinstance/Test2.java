package com.liboshuai.mall.tiny.zlearning.Test.literal.staticuse.d4_static_singleinstance;

/**
 * @author:Sun
 * @date04/12/20221:21 PM
 */
public class Test2 {
    public static void main(String[] args) {
        SingleInstance2 s1 = SingleInstance2.getInstance();
        SingleInstance2 s2 = SingleInstance2.getInstance();
        System.out.println(s1 == s2);
    }
}
