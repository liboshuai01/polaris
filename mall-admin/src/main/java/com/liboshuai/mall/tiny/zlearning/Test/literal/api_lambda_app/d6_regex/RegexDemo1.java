package com.liboshuai.mall.tiny.zlearning.Test.literal.api_lambda_app.d6_regex;

/**
 * @author:Sun
 * @date06/12/20229:51 PM
 */
public class RegexDemo1 {
    public static void main(String[] args) {
        System.out.println(checkQQ("251425998"));
        System.out.println(checkQQ("2514259a98"));
        System.out.println(checkQQ(null));
        System.out.println(checkQQ("2344"));

        System.out.println("-------------------------");
        // 正则表达式的初体验：
        System.out.println(checkQQ2("251425998"));
        System.out.println(checkQQ2("2514259a98"));
        System.out.println(checkQQ2(null));
        System.out.println(checkQQ2("2344"));
    }
    public static boolean checkQQ2(String qq){
        return qq != null && qq.matches("\\d{6,20}");
    }
    public static boolean checkQQ(String qq){
        if (qq == null || qq.length() < 6 || qq.length() > 20){
            return false;
        }
        for (int i =0;i < qq.length();i++){
            char ch = qq.charAt(i);
            if (ch < '0' || ch > '9'){
                return false;
            }
        }
        return true;
    }
}
