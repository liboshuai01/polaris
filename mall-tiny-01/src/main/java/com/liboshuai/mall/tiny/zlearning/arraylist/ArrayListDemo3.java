package com.liboshuai.mall.tiny.zlearning.arraylist;

import java.util.ArrayList;

/**
 * @author:Sun
 * @date02/12/202211:34 PM
 */
public class ArrayListDemo3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("java");
        list.add("mysql");
        list.add("mybatis");
        list.add("java");
        list.add("Html");

        String e = list.get(3);
        System.out.println(e);
        System.out.println(list.size());

        for (int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

        System.out.println(list);
        String e2 =list.remove(2);
        System.out.println(e2);
        System.out.println(list);

        System.out.println(list.remove("mybatis"));
        System.out.println(list);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("java");
        list2.add("王宝强");
        list2.add("Java");
        list2.add("MySQL");

        System.out.println(list2.remove("java"));
        System.out.println(list2);

        String e3 = list2.set(0,"贾乃亮");
        System.out.println(e3);
        System.out.println(list2);
    }
}
