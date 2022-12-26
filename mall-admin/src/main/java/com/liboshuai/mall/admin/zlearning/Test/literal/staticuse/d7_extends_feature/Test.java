package com.liboshuai.mall.admin.zlearning.Test.literal.staticuse.d7_extends_feature;

/**
 * @author:Sun
 * @date04/12/20221:45 PM
 */
public class Test {
    public static void main(String[] args) {
        Tiger t = new Tiger();
        System.out.println(Tiger.location);

    }
}

class Animal{

    private void eat(){
        System.out.println("动物要吃东西~~");
    }

    public static String location = "长隆动物园";
}

class Tiger extends Animal{

}