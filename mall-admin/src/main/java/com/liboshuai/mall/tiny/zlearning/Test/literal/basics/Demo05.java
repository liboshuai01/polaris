package com.liboshuai.mall.tiny.zlearning.Test.literal.basics;

/**
 * @author:Sun
 * @date29/11/202210:31 PM
 */
public class Demo05 {
    public static void main(String[] args) {

        //++运算符
        int a = 10;
        a++;
        ++a;
        System.out.println(a);

        //--运算符
        int b = 10;
        b--;
        --b;
        System.out.println(b);

        System.out.println("----------------");

        int i = 10;
        int j = ++i;
        System.out.println(i);
        System.out.println(j);

        int m =10;
        int n = m++;
        System.out.println(m);
        System.out.println(n);

        System.out.println("___________________");

        int k = 3;
        int p = 5;

        int rs = k++ + ++k - --p + p-- - k-- + ++p + 2;
        System.out.println(k);
        System.out.println(p);
        System.out.println(rs);




    }
}
