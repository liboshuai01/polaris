package com.liboshuai.mall.tiny.zlearning.Test.literal.day06.d8_map_test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author:Sun
 * @date2022/12/1220:24
 */
public class MapTest1 {
    public static void main(String[] args) {

        String[] selects = {"A" , "B", "C", "D"};
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int i = 0; i < 80; i++){
            sb.append(selects[r.nextInt(selects.length)]);
        }
        System.out.println(sb);
        Map<Character,Integer> infos = new HashMap<>();
        for (int i = 0; i < sb.length();i++){
            char ch = sb.charAt(i);
            if (infos.containsKey(ch)){
                infos.put(ch,infos.get(ch)+1);
            }else{
                infos.put(ch,1);
            }
        }
        System.out.println(infos);
    }
}
