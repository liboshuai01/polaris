package com.liboshuai.mall.tiny.zlearning.Test.literal.basics;


/**
 * @author:Sun
 * @date29/11/202210:44 PM
 */
public class Demo08 {

    public static void main(String[] args) {
        double size = 9.8;
        double storage = 6;

        System.out.println(size >= 6.95 & storage >= 8);

        System.out.println(size>=6.95 | storage >= 8);

        System.out.println(!true);
        System.out.println(!false);

        System.out.println(false ^ true);
        System.out.println(true ^ false);
        System.out.println(true ^ true);
        System.out.println(false ^ false);


        System.out.println("-------------&& & || | 的区别------------");
        int  a =10;
        int b = 20;
        System.out.println(a>1 && ++b > 100);
        System.out.println(a > 100 & ++b > 10);
        System.out.println(b);

        int i = 10;
        int j =20;
        System.out.println(i>2 || ++j >10);
        System.out.println(i>2 | ++j > 30);
        System.out.println(j);

    }
}
