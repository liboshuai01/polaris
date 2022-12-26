package com.liboshuai.mall.admin.zlearning.Test.literal.day06.d6_map_api;

import java.util.*;

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

//        maps.clear();//清空集合
//        System.out.println(maps);


        System.out.println(maps.containsKey("娃娃"));
        System.out.println(maps.containsKey("娃娃2"));
        System.out.println(maps.containsKey("iphoneX"));

        System.out.println(maps.containsKey(100));
        System.out.println(maps.containsKey(10));
        System.out.println(maps.containsKey(22));

        Set<String> keys = maps.keySet();
        System.out.println(keys);

        Collection<Integer> values = maps.values();
        System.out.println(values);

        Map<String,Integer> map1 = new HashMap<>();
        map1.put("java1",1);
        map1.put("java2",100);
        Map<String,Integer> map2 = new HashMap<>();
        map2.put("java2",1);
        map2.put("java2",100);
        map1.putAll(map2);
        System.out.println(map1);
        System.out.println(map2);


    }
}
