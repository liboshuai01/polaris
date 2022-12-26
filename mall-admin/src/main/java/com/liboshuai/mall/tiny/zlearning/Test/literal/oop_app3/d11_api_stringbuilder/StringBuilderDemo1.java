package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_app3.d11_api_stringbuilder;

/**
 * @author:Sun
 * @date06/12/202212:37 PM
 */
public class StringBuilderDemo1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("b");
        sb.append("c");
        sb.append(1);
        sb.append(false);
        sb.append(3.3);
        sb.append("abc");
        System.out.println(sb);

        StringBuilder sb1 = new StringBuilder();

        sb1.append("a").append("b").append("c").append("我爱中国");
        System.out.println(sb1);

        sb1.reverse().append("110");
        System.out.println(sb1);

        System.out.println(sb1.length());

        StringBuilder sb2 = new StringBuilder();
        sb2.append("123").append("456");
        String re = sb2.toString();

        check(re);

    }
    public static void check(String data){
        System.out.println(data);
    }

}
