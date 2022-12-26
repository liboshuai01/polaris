package com.liboshuai.mall.admin.zlearning.Test.literal.basics;

/**
 * @author:Sun
 * @date29/11/202210:37 PM
 */
public class Demo06 {
    public static void main(String[] args) {
        int a = 10;
        int b = 200;
//        a = a+b;
        a+=b;
        System.out.println(a);


        byte i = 10;
        byte j = 20;
        //i = (byte)(i+j)
        i += j;
        System.out.println(i);

        int m =10;
        int n = 5;
        //m += n;
        // m-=n;
        //m*=n;
        //m/=n;
        m%=n;
        System.out.println(m);


    }
}
