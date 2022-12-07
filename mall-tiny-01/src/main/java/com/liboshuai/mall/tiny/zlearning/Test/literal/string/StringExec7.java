package com.liboshuai.mall.tiny.zlearning.Test.literal.string;

import java.util.Scanner;

/**
 * @author:Sun
 * @date03/12/202212:55 AM
 */
public class StringExec7 {
    public static void main(String[] args) {
        String okLoginName = "admin";
        String okPassword = "itheima";

        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 3; i++){
            System.out.println("请您输入登录名称：");
            String loginName = scanner.next();
            System.out.println("请您输入登录密码：");
            String password = scanner.next();

            if (okLoginName.equals(loginName)){
                if (okPassword.equals(password)){
                    System.out.println("登录成功！欢迎进入系统随意浏览~~~~");
                    break;
                }else {
                    System.out.println("您的密码不正确！您还剩余" + (3 - i) +"次机会登录！");
                }
            }else {
                System.out.println("您的登录名称不正确！您还剩余" + (3 - i) +"次机会登录！");
            }
        }
    }
}
