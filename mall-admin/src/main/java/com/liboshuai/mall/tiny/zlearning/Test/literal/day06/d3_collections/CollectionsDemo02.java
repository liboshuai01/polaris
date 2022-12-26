package com.liboshuai.mall.tiny.zlearning.Test.literal.day06.d3_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author:Sun
 * @date2022/12/823:00
 */
public class CollectionsDemo02 {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();

        apples.add(new Apple("红富士", "红色", 9.9, 500));
        apples.add(new Apple("青苹果", "绿色", 15.9, 300));
        apples.add(new Apple("绿苹果", "青色", 29.9, 400));
        apples.add(new Apple("黄苹果", "黄色", 9.8, 500));

        Collections.sort(apples,((o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice())));
        System.out.println(apples);

    }
}
