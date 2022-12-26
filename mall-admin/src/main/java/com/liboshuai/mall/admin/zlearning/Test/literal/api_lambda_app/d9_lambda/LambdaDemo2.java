package com.liboshuai.mall.admin.zlearning.Test.literal.api_lambda_app.d9_lambda;

/**
 * @author:Sun
 * @date06/12/202210:48 PM
 */
public class LambdaDemo2 {
    public static void main(String[] args) {

        Swimming s1 = () -> System.out.println("老师游泳贼溜~~~~~");
        go(s1);
        go(() -> System.out.println("学生游泳很开心~~~"));
    }
    public static void go(Swimming s){
        System.out.println("开始。。。");
        s.swim();
        System.out.println("结束。。。");
    }
}

@FunctionalInterface
interface Swimming{
    void swim();
}