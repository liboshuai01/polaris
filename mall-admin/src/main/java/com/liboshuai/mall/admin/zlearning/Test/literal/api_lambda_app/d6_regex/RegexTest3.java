package com.liboshuai.mall.admin.zlearning.Test.literal.api_lambda_app.d6_regex;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:Sun
 * @date06/12/20229:51 PM
 */
public class RegexTest3 {
    public static void main(String[] args) {


        // checkPhone();
        // checkEmail();
        // checkTel();

        int[] arr = {10, 4, 5,3, 4,6,  2};
        System.out.println(Arrays.binarySearch(arr, 2));


    }
    public static void checkTel(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请您输入您的电话号码：");
            String tel = sc.next();

            if (tel.matches("0\\d{2,6}-?\\d{5,20}")){
                System.out.println("格式正确，注册完成！");
                break;
            }else {
                System.out.println("格式有误！");
            }
        }
    }
    public static void checkEmail(){
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请您输入您的注册邮箱：");
            String email = sc.next();

            if (email.matches("\\w{1,30}@[a-zA-Z0-9]{2,20}(\\.[a-zA-Z0-9]{2,20}){1,2}")){
                System.out.println("邮箱格式正确，注册完成！");
                break;
            }else {
                System.out.println("格式有误！");
            }


        }
    }
    public static void checkPhone(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("请您输入您的注册手机号码：");
            String phone = sc.next();
            if (phone.matches("1[3-9]\\d{9}")){
                System.out.println("手机号码格式正确，注册完成！");
                break;
            }else {
                System.out.println("格式有误！");
            }
        }
    }

}
