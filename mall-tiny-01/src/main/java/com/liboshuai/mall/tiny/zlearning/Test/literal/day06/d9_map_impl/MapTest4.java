package com.liboshuai.mall.tiny.zlearning.Test.literal.day06.d9_map_impl;

import java.util.*;

/**
 * @author:Sun
 * @date2022/12/1220:32
 */
public class MapTest4 {
    public static void main(String[] args) {


        Map<String, List<String>> data = new HashMap<>();
        List<String> selects = new ArrayList<>();
        Collections.addAll(selects,"A","C");
        data.put("罗勇",selects);
        List<String> selects1 = new ArrayList<>();
        Collections.addAll(selects1,"B","C","D");
        data.put("胡涛",selects1);

        List<String> selects2 = new ArrayList<>();
        Collections.addAll(selects2,"A",  "B", "C" , "D");
        data.put("刘军", selects2);
        System.out.println(data);

        Map<String,Integer> infos = new HashMap<>();

        Collection<List<String>> values = data.values();
        System.out.println(values);

        for (List<String> value : values){
            for (String s : value){
                if(infos.containsKey(s)){
                    infos.put(s,infos.get(s)+1);

                }else {
                    infos.put(s,1);
                }
            }
        }
        System.out.println(infos);




    }
}
