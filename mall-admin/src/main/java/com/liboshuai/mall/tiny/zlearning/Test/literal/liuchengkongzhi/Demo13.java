package com.liboshuai.mall.tiny.zlearning.Test.literal.liuchengkongzhi;

/**
 * @author:Sun
 * @date30/11/202212:00 AM
 */
public class Demo13 {
    public static void main(String[] args) {

        int count = 0;

        for (int i = 100; i <= 999; i++){

            int ge = i % 10;
            int shi = i /10 % 10;
            int bai = i /100;

            if((ge*ge*ge + shi*shi*shi + bai*bai*bai)==i){
                System.out.println(i+"\t");
                count++;
            }
        }
        System.out.println();
        System.out.println(count);
    }
}
