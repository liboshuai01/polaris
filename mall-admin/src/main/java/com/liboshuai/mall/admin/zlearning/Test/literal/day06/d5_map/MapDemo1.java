package com.liboshuai.mall.admin.zlearning.Test.literal.day06.d5_map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author:Sun
 * @date2022/12/823:32
 */
public class MapDemo1 {
    public static void main(String[] args) {
        Map<String,Integer> maps = new LinkedHashMap<>();
        maps.put("鸿星尔克", 3);
        maps.put("Java", 1);
        maps.put("枸杞", 100);
        maps.put("Java", 100); // 覆盖前面的数据
        maps.put(null, null);
        System.out.println(maps);
    }
}
