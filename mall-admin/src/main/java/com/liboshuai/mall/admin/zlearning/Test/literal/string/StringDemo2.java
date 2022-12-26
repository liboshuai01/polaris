package com.liboshuai.mall.admin.zlearning.Test.literal.string;

import javax.swing.*;

/**
 * @author:Sun
 * @date03/12/202212:27 AM
 */
public class StringDemo2 {
    public static void main(String[] args) {
        String name = "我爱中国";
        System.out.println(name);

        String s1 = new String();
        System.out.println(s1);

        String s2 = new String("我是中国人");

        System.out.println(s2);

        char[] chars = {'a','b','中','国'};
        String s3 = new String(chars);
        System.out.println(s3);

        byte[] bytes = {97, 98, 99, 65, 66, 67};
        String s4 = new String(bytes);
        System.out.println(s4);

        System.out.println("---------------------------");
        String ss1 = "abc";
        String ss2 = "abc";

        System.out.println(ss1 == ss2);
        char[] chars1 = {'a' , 'b' , 'c'};
        String ss3 = new String(chars1);
        String ss4 = new String(chars1);
        System.out.println(ss3 == ss4);


    }
}
