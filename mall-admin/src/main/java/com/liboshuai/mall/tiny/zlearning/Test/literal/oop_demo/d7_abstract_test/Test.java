package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_demo.d7_abstract_test;

/**
 * @author:Sun
 * @date05/12/20229:47 PM
 */
public class Test {
    public static void main(String[] args) {
        GoldCard c = new GoldCard();
        c.setMoney(100000);
        c.setUserName("zs");
        c.pay(300);
        System.out.println("剩余:" + c.getMoney());
    }

}
