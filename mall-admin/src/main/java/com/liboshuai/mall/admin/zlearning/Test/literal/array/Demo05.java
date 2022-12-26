package com.liboshuai.mall.admin.zlearning.Test.literal.array;

/**
 * @author:Sun
 * @date30/11/202210:47 AM
 */
public class Demo05 {
    public static void main(String[] args) {
        //数组元素求和
        int[] money = {16,32,8,100,78};

        int sum = 0;
        for (int i = 0; i < money.length;i++){
            sum+=money[i];

        }
        System.out.println("数组和是"+sum);
    }
}
