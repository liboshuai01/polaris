package com.liboshuai.mall.admin.zlearning.Test.literal.practice;

import java.util.Scanner;

/**
 * @author:Sun
 * @date30/11/20228:19 PM
 */
public class Demo01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("机票原价");
        double price = sc.nextDouble();
        System.out.println("月份：");
        int month = sc.nextInt();
        System.out.println("仓位类型");
        String type = sc.next();
        double rs = calc(price,month,type);
        System.out.println("你当前的购买机票的价格是："+rs);

    }

    public static double calc(double money,int month,String type){
        if(money >= 5 && month <= 10){
            //旺季
            switch(type){
                case "经济舱":
                    money *= 0.85;
                    break;
                case "头等舱":
                    money *= 0.9;
                    break;
                default:
                    System.out.println("你输入的舱位不正确");
                    money = -1;

            }

        } else if (money == 11 || money == 12 || money >= 1 && money <= 4) {
            switch (type){
                case "经济舱":
                    money *= 0.65;
                    break;
                case "头等舱":
                    money *= 0.7;
                    break;
                default:
                    System.out.println("你输入的舱位不正确");
                    money = -1;
            }
        }else {
            System.out.println("月份有问题");
            money = -1;
        }
        return money;
    }
}
