package com.liboshuai.mall.tiny.zlearning.Test.literal.basics;

/**
 * @author:Sun
 * @date29/11/202210:52 PM
 */
public class Demo09 {
    public static void main(String[] args) {

        double score = 18;
        String rs = score >= 60 ? "考试通过" : "挂科";
        System.out.println(rs);



        int a =10000;
        int b =2000;
        int max = a > b ? a:b;
        System.out.println(max);


        System.out.println("-----------------------------");
        int i = 10;
        int j = 30;
        int k = 50;
        //
        int temp = i > j ? i:j;
        int rsMax = temp > k ? temp : k;
        System.out.println(rsMax);


        System.out.println("---------------------");

        int rsMax1 = i>j ? (i > k ? i : k) :(j > k ? j : k);
        System.out.println(rsMax1);
    }
}
