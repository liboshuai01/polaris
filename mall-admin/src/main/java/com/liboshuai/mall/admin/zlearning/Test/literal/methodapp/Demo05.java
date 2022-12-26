package com.liboshuai.mall.admin.zlearning.Test.literal.methodapp;

/**
 * @author:Sun
 * @date30/11/20221:26 PM
 */
public class Demo05 {
    public static void main(String[] args) {
        System.out.println("1-5的和是："+sum(5));
        System.out.println("-----------------");
        System.out.println("1-100的和是："+sum(100));

    }
    public static int sum(int n){
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += i;

        }
        return sum;
    }
}
