package com.liboshuai.mall.tiny.zlearning.Test.literal.day06.d6_map_api;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:Sun
 * @date2022/12/823:33
 */
public class MapDemo {
    public static void main(String[] args) {

        Map<String, Integer> maps = new HashMap<>();
        maps.put("iphoneX",10);
        maps.put("娃娃",20);
        maps.put("iphoneX",100);//  Map集合后面重复的键对应的元素会覆盖前面重复的整个元素！
        maps.put("huawei",100);
        maps.put("生活用品",10);
        maps.put("手表",10);
        // {huawei=100, 手表=10, 生活用品=10, iphoneX=100, 娃娃=20}
        System.out.println(maps);

        System.out.println(maps.isEmpty());

        Integer key = maps.get("huawei");
        System.out.println(key);
        System.out.println(maps.get("生活用品")); // 10
        System.out.println(maps.get("生活用品2")); // null

        System.out.println(maps.remove("iphoneX"));
        System.out.println(maps);













    }
}
