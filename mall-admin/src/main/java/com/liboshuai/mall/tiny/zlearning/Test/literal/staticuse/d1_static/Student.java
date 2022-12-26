package com.liboshuai.mall.tiny.zlearning.Test.literal.staticuse.d1_static;

/**
 * @author:Sun
 * @date04/12/202212:25 PM
 */
public class Student {

    private String name;

    public static int getMax(int age1,int age2){
        return age1 > age2 ? age1 : age2;
    }
    public void study(){
        System.out.println(name + "在好好学习，天天向上~");
    }

    public static void main(String[] args) {
        System.out.println(Student.getMax(10,3));
        System.out.println(getMax(10,23));

        Student s = new Student();
        s.name = "猪八戒";
        s.study();

        System.out.println(s.getMax(13,14));

    }
}
