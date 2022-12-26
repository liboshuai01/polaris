package com.liboshuai.mall.tiny.zlearning.Test.literal.day06.d1_collection_set;

import java.util.HashSet;
import java.util.Set;

/**
 * @author:Sun
 * @date2022/12/822:38
 */
public class SetDemo3 {
    public static void main(String[] args) {
        Set<Student> sets = new HashSet<>();
        Student s1 = new Student("无恙", 20, '男');
        Student s2 = new Student("无恙", 20, '男');
        Student s3 = new Student("周雄", 21, '男');
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());

        sets.add(s1);
        sets.add(s2);
        sets.add(s3);
        System.out.println(sets);
    }
}
