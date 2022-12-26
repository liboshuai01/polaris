package com.liboshuai.mall.admin.zlearning.Test.literal.day06.d7_map_traversal;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author:Sun
 * @date2022/12/1220:13
 */
public class MapDemo03 {
    public static void main(String[] args) {
        Map<String,Integer> maps = new HashMap<>();
        maps.put("娃娃",1);
        maps.put("iphone",100);
        maps.put("huawei",1000);
        maps.put("生活用品",10);
        maps.put("手表",20);
        System.out.println(maps);


        Set<String> keys = maps.keySet();
        for (String key:keys){
            int value = maps.get(key);
            System.out.println(key + "==>" +value);
        }
    }
}
