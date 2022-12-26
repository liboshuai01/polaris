package com.liboshuai.mall.admin.zlearning.Test.literal.api_lambda_app.collection_app.d5_collection_list;

import java.util.ArrayList;

/**
 * @author:Sun
 * @date06/12/202211:27 PM
 */
public class ListDemo01 {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Java");
        list.add("HTML");
        list.add("HTML");
        list.add("MySQL");
        list.add("MySQL");

        list.add(2,"黑马");
        System.out.println(list);

        System.out.println(list.remove(1));
        System.out.println(list);


        System.out.println(list.get(1));

        System.out.println(list.set(1,"传智教育"));
        System.out.println(list);


    }
}
