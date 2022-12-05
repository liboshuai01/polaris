package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_demo.d7_abstract_test;

/**
 * @author:Sun
 * @date05/12/20229:47 PM
 */
public abstract class Card {

    private String userName;
    private double money;

    public abstract void pay(double money2);

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
