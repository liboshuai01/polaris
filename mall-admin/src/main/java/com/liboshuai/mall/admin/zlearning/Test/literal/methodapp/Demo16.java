package com.liboshuai.mall.admin.zlearning.Test.literal.methodapp;


/**
 * @author:Sun
 * @date30/11/20222:48 PM
 */
public class Demo16 {
    public static void main(String[] args) {
        System.out.println("main:start");
        chu(10,0);
        System.out.println("main:stop");
    }
    public static void chu(int a,int b){
        if(b==0){
            System.out.println("你输入的数据有问题");
            return;
        }
        int c = a/b;
        System.out.println("结果："+c);
    }
}
