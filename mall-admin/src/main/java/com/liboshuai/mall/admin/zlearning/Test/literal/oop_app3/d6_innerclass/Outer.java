package com.liboshuai.mall.admin.zlearning.Test.literal.oop_app3.d6_innerclass;

/**
 * @author:Sun
 * @date06/12/202212:16 AM
 */
public class Outer {
    public static int num = 111;
    private String hobby;

    public Outer() {
    }

    public Outer(String hobby) {
        this.hobby = hobby;
    }
    public class Inner{
        private String name;
        private int age;
//        public static int a = 100;

        public void show(){
            System.out.println("名称：" + name);
            System.out.println("数量：" + num);
            System.out.println("爱好：" + hobby);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
