package com.liboshuai.mall.admin.zlearning.Test.literal.liuchengkongzhi;

/**
 * @author:Sun
 * @date29/11/202211:56 PM
 */
public class Demo12 {
    public static void main(String[] args) {

        int sum = 0;

        for (int i = 1; i <= 10; i++){


            if (i % 2 == 1){
                sum += i;
            }
        }
        System.out.println("1-10的奇数："+sum);
        System.out.println("_________________");

        int sum1 = 0;
        for (int i = 1; i <= 10; i+=2){
            sum1 += i;
        }
        System.out.println(sum1);


    }
}
