package com.liboshuai.mall.tiny.zlearning.Test.literal.practice;

import java.util.Random;

/**
 * @author:Sun
 * @date30/11/20228:43 PM
 */
public class Demo03 {
    public static void main(String[] args) {
        String code = createCode(4);
        System.out.println("随机验证码："+ code);

    }
    public static String createCode(int n){
        String code = "";
        Random r = new Random();
        for (int i = 0; i < n; i++){

            int type = r.nextInt(3);
            switch(type){
                case 0:
                    char ch = (char)(r.nextInt(26)+65);
                    code += ch;
                    System.out.println(code);
                    break;
                case 1:
                    char ch1 = (char)(r.nextInt(26)+97);
                    code += ch1;
                    System.out.println(code);
                    break;
                case 2:
                    code += r.nextInt(10);
                    System.out.println(code);
                    break;
            }

        }
        return code;

    }
}
