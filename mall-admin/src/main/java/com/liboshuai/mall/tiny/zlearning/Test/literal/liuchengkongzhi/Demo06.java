package com.liboshuai.mall.tiny.zlearning.Test.literal.liuchengkongzhi;

/**
 * @author:Sun
 * @date29/11/202211:31 PM
 */
public class Demo06 {

    public static void main(String[] args) {

        OUT:
        for (int i = 0; i <= 3;i++){
            System.out.println("挖矿");
            if (i==2){
                break OUT;

            }
            System.out.println("-----------------");
        }
        System.out.println("==============");

        OUT:
        for (int i = 0; i <= 3; i++){
            for (int j = 1; j <= 5; j++){
                System.out.println("使劲挖");
                if (i == 2 && j== 3){
                    continue OUT;
                }
            }
            System.out.println("------------");
        }


    }
}
