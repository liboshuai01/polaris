package com.liboshuai.mall.admin.zlearning.Test.literal.api_lambda_app.collection_app.d3_collection_traversal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

/**
 * @author:Sun
 * @date06/12/202211:14 PM
 */
public class CollectionDemo03 {
    public static void main(String[] args) {

        Collection<String> lists = new ArrayList<>();

        lists.add("赵敏");
        lists.add("小昭");
        lists.add("殷素素");
        lists.add("周芷若");
        System.out.println(lists);

        lists.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        lists.forEach(System.out::println );
    }
}
