package com.liboshuai.mall.admin.zlearning.Test.literal.api_lambda_app.collection_app.d7_genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:Sun
 * @date06/12/202211:44 PM
 */
public class GenericityDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("java");
        list.add("java2");

        List<String> list1 = new ArrayList<>();
        list1.add("java");
        list1.add("Spring");


        for (String s : list1){
            System.out.println(s);

        }

        System.out.println("-----------------------");


        List<Object> list2 = new ArrayList<>();

        list2.add(23);
        list2.add(23.3);
        list2.add("Java");


    }
}
