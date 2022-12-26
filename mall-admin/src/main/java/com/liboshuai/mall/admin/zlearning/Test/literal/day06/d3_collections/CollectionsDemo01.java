package com.liboshuai.mall.admin.zlearning.Test.literal.day06.d3_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author:Sun
 * @date2022/12/823:00
 */
public class CollectionsDemo01 {
    public static void main(String[] args) {
        List<String> names= new ArrayList<>();
        Collections.addAll(names,"楚留香","胡铁花", "张无忌","陆小凤");
        System.out.println(names);

        Collections.shuffle(names);
        System.out.println(names);
        
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,12, 23, 2, 4);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);


    }
}
