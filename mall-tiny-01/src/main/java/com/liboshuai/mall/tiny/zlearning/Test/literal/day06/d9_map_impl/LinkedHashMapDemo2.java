package com.liboshuai.mall.tiny.zlearning.Test.literal.day06.d9_map_impl;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author:Sun
 * @date2022/12/1220:32
 */
public class LinkedHashMapDemo2 {
    public static void main(String[] args) {
        Map<String,Integer> maps = new LinkedHashMap<>();
        maps.put("鸿星尔克",3);
        maps.put("java",1);
        maps.put("枸杞",100);
        maps.put("java",100);
        maps.put(null,null);
        System.out.println(maps);
    }
}
