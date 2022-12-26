package com.liboshuai.mall.tiny.zlearning.Test.literal.liuchengkongzhi;

/**
 * @author:Sun
 * @date29/11/202211:29 PM
 */
public class Demo05 {

    public static void main(String[] args) {

        for (int i = 0; i<5; i++){
            System.out.println("无情的代码机器");
            if(i==2){
                break;

            }
        }

        for (int i = 1; i <= 5; i++){

            if (i==3){
                continue;
            }
            System.out.println("挖矿"+i);
        }
    }
}
