package com.liboshuai.mall.admin.zlearning.Test.literal.arraylist;

import java.util.ArrayList;

/**
 * @author:Sun
 * @date02/12/202211:29 PM
 */
public class ArrayListDemo1 {
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add("java");
        list.add("Mysql");
        list.add("java");
        list.add("heima");
        list.add(23);
        list.add(23.5);
        list.add(false);
        System.out.println(list.add("ok"));
        System.out.println(list);
    }
}
