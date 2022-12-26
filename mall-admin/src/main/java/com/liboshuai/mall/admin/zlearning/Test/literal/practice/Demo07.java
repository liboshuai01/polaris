package com.liboshuai.mall.admin.zlearning.Test.literal.practice;

import java.util.Random;
import java.util.Scanner;

/**
 * @author:Sun
 * @date02/12/20227:56 PM
 */
public class Demo07 {
    public static void main(String[] args) {
        // 1、定义一个数组存储可以抽奖的金额 总数
        int[] money = {2, 588, 888, 1000, 10000};

        // 2、定义一个数组用于存储已经被抽中的奖金金额。
        int[] lockMoney = new int[money.length];

        // 3、开始模拟抽奖逻辑
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        for (int i = 0; i < money.length; i++) {
            // 分别代表抽奖一次。
            System.out.println("您要开始打开红包吗，您可以输入任意内容进行抽奖：");
            sc.next(); // 目的是为了让程序在这里等一下，直到用户按了数据和回车就下来抽奖一次！

            while (true) {
                // 4、开始抽奖了，随机一个索引取提取金额
                int index = r.nextInt(money.length);
                int currentMoney = money[index];

                boolean flag = true; // 代表默认没有被抽过

                // 5、判断这个红包金额之前是否有人抽中过！
                for (int j = 0; j < lockMoney.length; j++) {
                    if(lockMoney[j] == currentMoney){
                        // 说明这个金额已经被抽过了！
                        flag = false; // 表示已经被抽走了
                        break;
                    }
                }

                if(flag){
                    System.out.println("您当前很幸运，抽中了：" + currentMoney);
                    // 必须把这个金额放到被抽中的数组中去
                    lockMoney[i] = currentMoney;
                    break; // 当次抽象已经结束！
                }
            }
        }
    }
}
