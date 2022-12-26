package com.liboshuai.mall.tiny.zlearning.Test.literal.string;

import java.util.Scanner;

/**
 * @author:Sun
 * @date03/12/202212:34 AM
 */
public class StringAPIEqualsDemo4 {
    public static void main(String[] args) {
        String okName = "sun";
        String okPassword = "123456";

        Scanner scanner = new Scanner(System.in);
        System.out.println("登录名称:");
        String name = scanner.next();
        System.out.println("登录密码:");
        String password = scanner.next();

        if (okName.equals(name) && okPassword.equals(password)){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }
        String sysCode = "1231234";
        String code1 = "31234";

        System.out.println(sysCode.equals(code1));
        System.out.println(sysCode.equalsIgnoreCase(code1));


    }
}
