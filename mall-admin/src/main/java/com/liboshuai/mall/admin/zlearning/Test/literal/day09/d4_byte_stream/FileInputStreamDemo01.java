package com.liboshuai.mall.admin.zlearning.Test.literal.day09.d4_byte_stream;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo01 {

    public static void main(String[] args) throws Exception {

        InputStream is = new FileInputStream("mall-tiny-01/src/main/java/com/liboshuai/mall/tiny/zlearning/Test/literal/day09/data.txt");

//        int b1 = is.read();
//        System.out.println((char)b1);
//
//        int b2 = is.read();
//        System.out.println((char) b2);
//
//        int b3 = is.read();
//        System.out.println((char) b3);

        int b;
        while((b = is.read()) != -1){
            System.out.println((char) b);
        }


    }

}
