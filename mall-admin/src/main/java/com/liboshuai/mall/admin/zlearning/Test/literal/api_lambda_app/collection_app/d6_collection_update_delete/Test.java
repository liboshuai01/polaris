package com.liboshuai.mall.admin.zlearning.Test.literal.api_lambda_app.collection_app.d6_collection_update_delete;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author:Sun
 * @date06/12/202211:38 PM
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("黑马");
        list.add("Java");
        list.add("Java");
        list.add("赵敏");
        list.add("赵敏");
        list.add("素素");
        System.out.println(list);

        Iterator<String> it = list.iterator();


        for (int i = list.size() - 1; i >= 0; i--){
            String ele = list.get(i);
            if ("Java".equals(ele)){
                list.remove(ele);
            }

        }
        System.out.println(list);

    }
}
