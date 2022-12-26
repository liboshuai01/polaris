package com.liboshuai.mall.tiny.zlearning.Test.literal.api_lambda_app.collection_app.d3_collection_traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author:Sun
 * @date06/12/202211:14 PM
 */
public class CollectionDemo02 {
    public static void main(String[] args) {
        Collection<String> lists = new ArrayList<>();
        lists.add("赵敏");
        lists.add("小昭");
        lists.add("殷素素");
        lists.add("周芷若");
        System.out.println(lists);

        for(String ele : lists){
            System.out.println(ele);
        }
        System.out.println("------------------");

        double[] scores = {100,99.5,59.5};
        for (double score : scores){
            System.out.println(score);
        }
        System.out.println(Arrays.toString(scores));
    }
}
