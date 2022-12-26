package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_app3.d5_innerclass_static;

/**
 * @author:Sun
 * @date06/12/202212:07 AM
 */
public class Outer {
    public static int a = 100;
    private String hobby;

    /**
     * 静态成员内部类
     *
     */
    public static class Inner{

        private String name;
        private int age;
        public static String schoolName;

        //无参构造器
        public Inner() {
        }

        public Inner(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public void show(){
            System.out.println("名称：" + name);
            System.out.println(a);
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

        public static String getSchoolName() {
            return schoolName;
        }

        public static void setSchoolName(String schoolName) {
            Inner.schoolName = schoolName;
        }
    }


}
