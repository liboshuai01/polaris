package com.liboshuai.mall.admin.zlearning.Test.literal.staticuse.d12_this;

/**
 * @author:Sun
 * @date04/12/20222:25 PM
 */
public class Student {
    private String name;
    private String schoolName;

    public Student() {
    }
    public Student(String name){
        this(name,"黑马程序员");
    }

    public Student(String name, String schoolName) {
        this.name = name;
        this.schoolName = schoolName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
