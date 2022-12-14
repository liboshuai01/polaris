package com.liboshuai.mall.tiny.zlearning.Test.literal.day09.d1_file;

import java.io.File;

/**
 * @author:Sun
 * @date2022/12/1419:36
 */
public class FileDemo {
    public static void main(String[] args) {
        File f = new File("D:" + File.separator+"resources"+ File.separator +"xueshan.jpeg");
        long size = f.length();
        System.out.println(size);

        File f1 = new File("H:\\资源整合\\file\\图片\\壁纸\\106826.jpg");
        System.out.println(f1.length());

        File f2 = new File("day09\\data.txt");
        System.out.println(f2.length());
        test(1);


    }
    public static int test(int a){

        if (a==5+1){

            return a;
        }
        System.out.println(a);


        return test(++a);
    }
}
