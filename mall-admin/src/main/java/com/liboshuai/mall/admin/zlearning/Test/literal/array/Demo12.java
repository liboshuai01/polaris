package com.liboshuai.mall.admin.zlearning.Test.literal.array;

/**
 * @author:Sun
 * @date30/11/202211:35 AM
 */
public class Demo12 {
    public static void main(String[] args) {

        int[] number = new int[12];
        number[0] = 1;
        number[1] = 1;

        for (int i = 2; i < number.length;i++){
            number[i] = number[i - 1] + number[i - 2];
        }
        for (int i = 0; i < number.length; i++){
            System.out.println((i+1)+"月兔子数："+ number[i]);
        }


    }
}
