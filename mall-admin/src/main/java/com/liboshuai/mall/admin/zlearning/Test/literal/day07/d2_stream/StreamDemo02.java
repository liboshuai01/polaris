package com.liboshuai.mall.admin.zlearning.Test.literal.day07.d2_stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author:Sun
 * @date2022/12/1220:58
 */
public class StreamDemo02 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        Stream<String> s = list.stream();

        Map<String,Integer> maps = new HashMap<>();
        Stream<String> keyStream = maps.keySet().stream();
        Stream<Integer> valueStream = maps.values().stream();

        Stream<Map.Entry<String,Integer>> keyAndValueStream = maps.entrySet().stream();
        String[] names = {"赵敏","小昭","灭绝","周芷若"};
        Stream<String> nameStream = Arrays.stream(names);
        Stream<String> nameStream2 = Stream.of(names);


    }
}
