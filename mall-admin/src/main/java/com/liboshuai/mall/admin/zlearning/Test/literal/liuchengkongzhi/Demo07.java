package com.liboshuai.mall.admin.zlearning.Test.literal.liuchengkongzhi;

import java.util.Scanner;

/**
 * @author:Sun
 * @date29/11/202211:39 PM
 */
public class Demo07 {
    public static void main(String[] args) {
        /*for (; ;){
            System.out.println("死循环");

        }*/

        /*while(true){
            System.out.println("gogogo");
        }*/

        int okPassword = 520;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("输入正确的密码");
            int password = sc.nextInt();
            if (password == okPassword){
                System.out.println("密码正确");
                break;
            }
            System.out.println("密码错误");
        }

    }
}
