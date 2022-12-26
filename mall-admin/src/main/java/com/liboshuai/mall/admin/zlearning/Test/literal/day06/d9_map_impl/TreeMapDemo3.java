package com.liboshuai.mall.admin.zlearning.Test.literal.day06.d9_map_impl;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author:Sun
 * @date2022/12/1220:32
 */
public class TreeMapDemo3 {
    public static void main(String[] args) {
        Map<Integer, String> maps1 = new TreeMap<>();
        maps1.put(13 , "王麻子");
        maps1.put(1 , "张三");
        maps1.put(3 , "县长");
        System.out.println(maps1);
    }
}
