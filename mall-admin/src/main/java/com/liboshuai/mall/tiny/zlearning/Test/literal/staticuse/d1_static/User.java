package com.liboshuai.mall.tiny.zlearning.Test.literal.staticuse.d1_static;

/**
 * @author:Sun
 * @date04/12/202212:52 PM
 */
public class User {
    public  static int onlineNumber = 161;

    private String name;

    private int age;

    public static void main(String[] args) {
        System.out.println(User.onlineNumber);

        User u = new User();
        u.name = "zs";
        u.age = 21;
        System.out.println(u.name);
        System.out.println(u.age);
        u.onlineNumber++;
        System.out.println(u.onlineNumber);
        User u2 = new User();
        u2.name = "zs1";
        u2.age = 22;

        System.out.println(u2.name);
        System.out.println(u2.age);
        u2.onlineNumber++;
        System.out.println(u2.onlineNumber);

        System.out.println(u.onlineNumber);
        System.out.println(User.onlineNumber);
        System.out.println(onlineNumber);
    }
}
