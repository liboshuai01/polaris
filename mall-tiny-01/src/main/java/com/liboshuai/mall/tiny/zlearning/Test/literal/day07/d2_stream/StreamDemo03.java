package com.liboshuai.mall.tiny.zlearning.Test.literal.day07.d2_stream;

/**
 * @author:Sun
 * @date2022/12/1220:58
 */

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 目标：Stream流的常用API
 forEach : 逐一处理(遍历)
 count：统计个数
 -- long count();
 filter : 过滤元素
 -- Stream<T> filter(Predicate<? super T> predicate)
 limit : 取前几个元素
 skip : 跳过前几个
 map : 加工方法
 concat : 合并流。
 */
public class StreamDemo03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张三丰");


        list.stream().map(s -> "倚天屠龙" + s).forEach(System.out::println);
        list.stream().skip(2).map(s -> "go" + s).forEach(System.out::println);
        list.stream().filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));

        long size = list.stream().filter(s -> s.length() == 3).count();
        System.out.println(size);
        list.stream().filter(s -> s.startsWith("张")).limit(2).forEach(System.out::println);
        list.stream().filter(s -> s.startsWith("张")).skip(2).forEach(System.out::println);


        list.stream().map(s -> "黑马的" + s).forEach(a -> System.out.println(a));

        list.stream().map(s -> new Student(s)).forEach(student -> System.out.println(student));

        Stream<String> s1 = list.stream().filter(s -> s.startsWith("张"));
        Stream<String> s2 = Stream.of("java1","java2");
        Stream<String> s3 = Stream.concat(s1,s2);
        s3.distinct().forEach(s -> System.out.println(s));


    }
}
