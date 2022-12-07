package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_demo.d7_abstract_test;

/**
 * @author:Sun
 * @date05/12/20229:47 PM
 */
public class GoldCard extends Card{

    @Override
    public void pay(double money2) {
        System.out.println("您当前消费：" + money2);
        System.out.println("您卡片当前余额是：" + getMoney());

        double re = money2 * 0.8;

        System.out.println(getUserName()+":您实际支付：" + re);

        setMoney(getMoney() - re);

    }
}
