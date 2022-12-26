package com.liboshuai.mall.admin.zlearning.Test.literal.api_lambda_app.collection_app.d8_genericity_class;

/**
 * @author:Sun
 * @date2022/12/822:11
 */
public class Test {
    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("Java");
        list.add("Java");
        list.add("MySQL");
        list.remove("MySQL");
        System.out.println(list);

        MyArrayList<Integer> list2 = new MyArrayList<>();
        list2.add(23);
        list2.add(24);
        list2.add(24);
        list2.add(25);
        list2.remove(25);
        System.out.println(list2);
    }
}
