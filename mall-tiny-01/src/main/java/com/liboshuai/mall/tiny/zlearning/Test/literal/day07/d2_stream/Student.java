package com.liboshuai.mall.tiny.zlearning.Test.literal.day07.d2_stream;

/**
 * @author:Sun
 * @date2022/12/1220:58
 */
public class Student {
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
