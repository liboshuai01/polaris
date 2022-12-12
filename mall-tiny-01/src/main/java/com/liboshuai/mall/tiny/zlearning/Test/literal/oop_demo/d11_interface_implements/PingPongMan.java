package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_demo.d11_interface_implements;

/**
 * @author:Sun
 * @date05/12/202210:11 PM
 */
public class PingPongMan implements SportMan, Law{
    private  String name;

    public PingPongMan(String name) {
        this.name = name;
    }

    @Override
    public void rule() {
        System.out.println(name + "必须跑步训练！");
    }

    @Override
    public void run() {
        System.out.println(name + "要参加比赛，为国争光~！");
    }

    @Override
    public void competition() {
        System.out.println(name + "必须守法~~");
    }
}
