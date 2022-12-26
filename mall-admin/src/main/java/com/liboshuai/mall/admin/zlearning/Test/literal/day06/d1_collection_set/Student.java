package com.liboshuai.mall.admin.zlearning.Test.literal.day06.d1_collection_set;

import java.util.Objects;

/**
 * @author:Sun
 * @date2022/12/822:38
 */
public class Student {
    private String name;
    private int age;
    private  char sex;

    public Student() {
    }

    public Student(String name, int age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
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

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
    @Override
    public int hashCode(){
        return Objects.hash(name,age, sex);
    }
    @Override
    public String toString(){
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
