package com.liboshuai.mall.admin.zlearning.Test.literal.staticuse.d4_static_singleinstance;

/**
 * @author:Sun
 * @date04/12/20221:20 PM
 */
public class Test1 {
    public static void main(String[] args) {
        SingleInstance s1 = SingleInstance.instance;
        SingleInstance s2 = SingleInstance.instance;
        System.out.println(s1 == s2);

    }
}
