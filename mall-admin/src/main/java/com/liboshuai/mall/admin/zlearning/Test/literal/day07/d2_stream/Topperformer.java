package com.liboshuai.mall.admin.zlearning.Test.literal.day07.d2_stream;

/**
 * @author:Sun
 * @date2022/12/1220:58
 */
public class Topperformer {
    private String name;

    private double money;

    public Topperformer() {
    }

    public Topperformer(String name, double money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    @Override
    public String toString() {
        return "Topperformer{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
