package com.liboshuai.mall.tiny.zlearning.Test.literal.api_lambda_app.collection_app.d3_collection_traversal;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author:Sun
 * @date06/12/202211:14 PM
 */
public class CollectionDemo01 {
    public static void main(String[] args) {
        ArrayList<String> lists = new ArrayList<>();
        lists.add("赵敏");
        lists.add("小昭");
        lists.add("素素");
        lists.add("灭绝");
        System.out.println(lists);

        Iterator<String> it = lists.iterator();
//        String ele = it.next();
//        System.out.println(ele);
//        System.out.println(it.next());
//        System.out.println(it.next());
//        System.out.println(it.next());



        while(it.hasNext()){
            String ele = it.next();
            System.out.println(ele);
        }
    }
}
