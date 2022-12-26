package com.liboshuai.mall.tiny.zlearning.Test.literal.day09.d2_recusion;

public class RecursionDemo04 {
    public static void main(String[] args) {
        System.out.println(f(1));
        System.out.println(f(2));
        System.out.println(f(3));


    }
    public static int f(int n){
        if (n==10) {
            return 1;
        }else {
            return 2 * f(n + 1) + 2;
        }

    }
}
