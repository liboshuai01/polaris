package com.liboshuai.mall.admin.zlearning.Test.literal.day06.d7_map_traversal;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author:Sun
 * @date2022/12/1220:13
 */
public class MapDemo01 {
    public static void main(String[] args) {
        Map<String , Integer> maps = new HashMap<>();
        // 1.添加元素: 无序，不重复，无索引。
        maps.put("娃娃",30);
        maps.put("iphoneX",100);
        maps.put("huawei",1000);
        maps.put("生活用品",10);
        maps.put("手表",10);
        System.out.println(maps);

        Set<Map.Entry<String,Integer>> entries = maps.entrySet();
        for (Map.Entry<String,Integer> entry : entries){
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + "===>" + value);
        }


    }
}
