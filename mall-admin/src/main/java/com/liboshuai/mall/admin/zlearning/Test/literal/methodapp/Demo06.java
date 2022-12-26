package com.liboshuai.mall.admin.zlearning.Test.literal.methodapp;

import java.util.Scanner;

/**
 * @author:Sun
 * @date30/11/20221:34 PM
 */
public class Demo06 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个整数：");
        int num = sc.nextInt();
        check(num);
    }
    public static void check(int num){
        if (num % 2 == 0){
            System.out.println("偶数:"+num);
        }else {
            System.out.println("奇数:"+num);
        }
    }
}
