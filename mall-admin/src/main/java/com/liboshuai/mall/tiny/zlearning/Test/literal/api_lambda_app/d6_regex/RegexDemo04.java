package com.liboshuai.mall.tiny.zlearning.Test.literal.api_lambda_app.d6_regex;

/**
 * @author:Sun
 * @date06/12/20229:51 PM
 */
public class RegexDemo04 {
    public static void main(String[] args) {
        String names = "小路dhdfhdf342蓉儿43fdffdfbjdfaf小何";

        String[] arrs = names.split("\\w+");
        for (int i = 0; i < args.length; i++){
            System.out.println(arrs[i]);
        }
        String names2 = names.replaceAll("\\w+"," ");
        System.out.println(names2);

    }
}
