package com.liboshuai.mall.tiny.zlearning.Test.literal.arraylist;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author:Sun
 * @date02/12/202211:52 PM
 */
public class ArrayListDemo6 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("20180302","叶孤城",23,"护理一班"));
        students.add(new Student("20180303","东方不败",23,"推拿二班"));
        students.add(new Student( "20180304","西门吹雪",26,"中药学四班"));
        students.add(new Student( "20180305","梅超风",26,"神经科2班"));
        System.out.println("学号\t\t名称\t年龄\t\t班级");

        for (int i = 0; i < students.size(); i++){
            Student s = students.get(i);
            System.out.println(s.getStudyId() +"\t\t" + s.getName()+"\t\t"
                    + s.getAge() +"\t\t" + s.getClassName());
        }
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请您输入要查询的学生的学号:");
            String id = sc.next();
            Student s = getStudentByStudyId(students,id);
            if (s == null){
                System.out.println("查无此人！");
            }
            else {
                // 找到了该学生对象了，信息如下
                System.out.println(s.getStudyId() +"\t\t" + s.getName()+"\t\t"
                        + s.getAge() +"\t\t" + s.getClassName());
            }
        }

    }
    public  static Student getStudentByStudyId(ArrayList<Student> students, String studyId){
        for (int i = 0; i < students.size();i++){
            Student s = students.get(i);
            if (s.getStudyId().equals(studyId)){
                    return s;
            }
        }
        return null;

    }
}
