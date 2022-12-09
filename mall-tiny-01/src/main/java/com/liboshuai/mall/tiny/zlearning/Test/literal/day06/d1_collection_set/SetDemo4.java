package com.liboshuai.mall.tiny.zlearning.Test.literal.day06.d1_collection_set;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author:Sun
 * @date2022/12/822:38
 */
public class SetDemo4 {
    public static void main(String[] args) {
        Set<String> sets = new LinkedHashSet<>();
        sets.add("MySQL");
        sets.add("MySQL");
        sets.add("Java");
        sets.add("Java");
        sets.add("HTML");
        sets.add("HTML");
        sets.add("SpringBoot");
        sets.add("SpringBoot");
        System.out.println(sets);
    }

}
