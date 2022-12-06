package com.liboshuai.mall.tiny.zlearning.Test.literal.string;

import java.util.Random;

/**
 * @author:Sun
 * @date03/12/202212:52 AM
 */
public class StringExec6 {
    public static void main(String[] args) {
        String datas = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        String code = "";
        Random r = new Random();
        for (int i = 0; i < 5; i++){
            int index = r.nextInt(datas.length());

            char c = datas.charAt(index);
            code += c;
        }
        System.out.println(code);
    }
}
