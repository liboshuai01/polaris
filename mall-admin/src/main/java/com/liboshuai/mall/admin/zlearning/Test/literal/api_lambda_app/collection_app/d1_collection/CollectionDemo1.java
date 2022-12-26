package com.liboshuai.mall.admin.zlearning.Test.literal.api_lambda_app.collection_app.d1_collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * @author:Sun
 * @date06/12/202210:58 PM
 */
public class CollectionDemo1 {
    public static void main(String[] args) {
        Collection list = new ArrayList();
        list.add("Java");
        list.add("Java");
        list.add("Mybatis");
        list.add(23);
        list.add(23);
        list.add(false);
        list.add(false);
        System.out.println(list);

        Collection list1 = new HashSet();
        list1.add("Java");
        list1.add("Java");
        list1.add("Mybatis");
        list1.add(23);
        list1.add(23);
        list1.add(false);
        list1.add(false);
        System.out.println(list1);
        System.out.println("-----------------------------");

        Collection<String> list2 = new ArrayList<>();
        list2.add("Java");
        // list2.add(23);
        list2.add("黑马");

        Collection<Integer> list3 = new ArrayList<>();
        list3.add(23);
        list3.add(233);
        list3.add(2333);

        Collection<Double> list4 = new ArrayList<>();
        list4.add(23.4);
        list4.add(233.0);
        list4.add(233.3);

    }
}
