package com.liboshuai.mall.tiny.zlearning.Test.literal.liuchengkongzhi;

/**
 * @author:Sun
 * @date29/11/202211:07 PM
 */
public class Demo01 {

    public static void main(String[] args) {


        int heartBeat = 30;
        if (heartBeat < 60 || heartBeat >100){

            System.out.println("你的心跳是："+heartBeat+"需要进一步的检查");
        }
        System.out.println("检查结束");

        double money = 1;
        if (money >= 1314){
            System.out.println("你当前发送红包成功");
        }
        else{
            System.out.println("你的晶体矿没有了");
        }

        int score = 199;
        if (score >= 0 && score <60){
            System.out.println("C");
        }
        else if(score >= 60 && score < 90){
            System.out.println("B");
        }
        else if(score >= 80 && score <= 100){
            System.out.println("A+");
        }else{
            System.out.println("你作弊了吧");
        }


    }
}
