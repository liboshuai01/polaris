package com.liboshuai.mall.admin.zlearning.Test.literal.day09.d4_byte_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyDemo05 {

    public static void main(String[] args) {

        try{
            InputStream is = new FileInputStream("D:\\coding\\java\\mall-tiny\\mall-tiny-01\\src\\main\\java\\com\\liboshuai\\mall\\tiny\\zlearning\\Test\\literal\\day09\\out04.txt");
            OutputStream os = new FileOutputStream("D:\\coding\\java\\mall-tiny\\mall-tiny-01\\src\\main\\java\\com\\liboshuai\\mall\\tiny\\zlearning\\Test\\literal\\day09\\out05.txt");

            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) != -1){
                os.write(buffer, 0,len);
            }
            System.out.println("复制完成了");



        } catch (Exception e){
            e.printStackTrace();
        }


    }



}
