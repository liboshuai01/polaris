package com.liboshuai.mall.admin.zlearning.Test.literal.api_lambda_app.d7_arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author:Sun
 * @date06/12/202210:20 PM
 */
public class ArraysDemo2 {
    public static void main(String[] args) {

        int[] ages = {34, 12, 42, 23};
        Arrays.sort(ages);
        System.out.println(Arrays.toString(ages));
        Integer[] ages1 = {34, 12, 42, 23};

        Arrays.sort(ages1, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(ages1));
        System.out.println("-------------------------");
        Student[] students = new Student[3];
        students[0] = new Student("吴磊",23 , 175.5);
        students[1] = new Student("谢鑫",18 , 185.5);
        students[2] = new Student("王亮",20 , 195.5);

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o2.getHeight(), o1.getHeight());
            }
        });
        System.out.println(Arrays.toString(students));

    }
}
