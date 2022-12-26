package com.liboshuai.mall.admin.zlearning.Test.literal.day09.d3_charset;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws Exception {
        String name = "abc";

        byte[] bytes = name.getBytes("GBK");
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));


        String rs = new String(bytes,"GBK");
        System.out.println(rs);


    }
}
