package com.liboshuai.mall.tiny.zlearning.Test.literal.api_lambda_app.collection_app.d2_collection_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author:Sun
 * @date06/12/202211:08 PM
 */
public class CollectionDemo {
    public static void main(String[] args) {

        Collection<String> c = new ArrayList<>();
        c.add("Java");
        c.add("HTML");
        System.out.println(c.add("HTML"));
        c.add("MySQL");
        c.add("Java");
        System.out.println(c.add("黑马"));
        System.out.println(c); // [Java, HTML, HTML, MySQL, Java, 黑马]

        // c.clear();
        // System.out.println(c);
        System.out.println(c.size());

        // 5.判断集合中是否包含某个元素。
        System.out.println(c.contains("Java"));  // true
        System.out.println(c.contains("java")); // false
        System.out.println(c.contains("黑马")); // true

        System.out.println(c.remove("java"));
        System.out.println(c);
        System.out.println(c.remove("java"));
        System.out.println(c);

        Object[] arrs = c.toArray();
        System.out.println("数组：" + Arrays.toString(arrs));
        System.out.println("----------------------拓展----------------------");


        Collection<String> c1 = new ArrayList<>();
        c1.add("java1");
        c1.add("java2");
        Collection<String> c2 = new ArrayList<>();
        c2.add("赵敏");
        c2.add("殷素素");
        c1.addAll(c2);
        System.out.println(c1);
        System.out.println(c2);


    }
}
