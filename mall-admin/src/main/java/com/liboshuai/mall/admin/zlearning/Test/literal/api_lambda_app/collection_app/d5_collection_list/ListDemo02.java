package com.liboshuai.mall.admin.zlearning.Test.literal.api_lambda_app.collection_app.d5_collection_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author:Sun
 * @date06/12/202211:28 PM
 */
public class ListDemo02 {
    public static void main(String[] args) {
        List<String> lists = new ArrayList<>();
        lists.add("java1");
        lists.add("java2");
        lists.add("java3");


        System.out.println("-----------------------");

        for (int i = 0; i < lists.size(); i++){
            String ele = lists.get(i);
            System.out.println(ele);
        }
        System.out.println("-----------------------");
        Iterator<String> it = lists.iterator();
        while(it.hasNext()){
            String ele = it.next();
            System.out.println(ele);
        }

        System.out.println("-----------------------");
        for (String ele : lists){
            System.out.println(ele);
        }

        System.out.println("-----------------------");

        lists.forEach(s -> {
            System.out.println(s);
        });

    }
}
