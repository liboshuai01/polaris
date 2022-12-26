package com.liboshuai.mall.admin.zlearning.Test.literal.string;

import java.util.Scanner;

/**
 * @author:Sun
 * @date03/12/202212:58 AM
 */
public class StringExec8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请您输入您的手机号码：");
        String tel =sc.next();

        String before = tel.substring(0,3);
        String after = tel.substring(7);
        
        String s = before + "****" + after;
        System.out.println(s);
    }
}
