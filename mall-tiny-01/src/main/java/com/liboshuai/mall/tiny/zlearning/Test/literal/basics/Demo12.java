package com.liboshuai.mall.tiny.zlearning.Test.literal.basics;

import java.util.Scanner;

/**
 * @author:Sun
 * @date29/11/202211:03 PM
 */
public class Demo12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入你的年龄");

        int age = sc.nextInt();
        System.out.println("你的年龄是"+age);

        System.out.println("输入你的名称");

        String name = sc.next();
        System.out.println("你的名称是："+name);


    }

}
