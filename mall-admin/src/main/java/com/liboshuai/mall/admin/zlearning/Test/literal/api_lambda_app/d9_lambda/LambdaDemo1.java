package com.liboshuai.mall.admin.zlearning.Test.literal.api_lambda_app.d9_lambda;

/**
 * @author:Sun
 * @date06/12/202210:47 PM
 */
public class LambdaDemo1 {
    public static void main(String[] args) {
        Animal a = new Animal() {
            @Override
            public void run() {
                System.out.println("乌龟跑的很慢~~~~~");
            }
        };
        a.run();

    }
}
abstract class Animal{
    public abstract void run();
}
