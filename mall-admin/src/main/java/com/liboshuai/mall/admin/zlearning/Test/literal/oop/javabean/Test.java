package com.liboshuai.mall.admin.zlearning.Test.literal.oop.javabean;

/**
 * @author:Sun
 * @date02/12/202210:34 PM
 */
public class Test {
    public static void main(String[] args) {
        User user =new User();
        user.setName("二狗");
        user.setHeight(187);
        user.setSalary(500000);
        user.setAddress("zh");
        user.setPhone("1231231313");

        System.out.println(user.getName());
        System.out.println(user.getHeight());
        System.out.println(user.getSalary());
        System.out.println(user.getAddress());
        System.out.println(user.getPhone());

        System.out.println("===================");

        User user1 = new User();
        System.out.println(user1.getName());
        System.out.println(user1.getHeight());
        System.out.println(user1.getSalary());
        System.out.println(user1.getAddress());
        System.out.println(user1.getPhone());

    }
}
