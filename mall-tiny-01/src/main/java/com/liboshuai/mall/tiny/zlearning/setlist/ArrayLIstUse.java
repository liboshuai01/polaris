package com.liboshuai.mall.tiny.zlearning.setlist;

import java.util.ArrayList;

/**
 * @author:Sun
 * @date29/11/202210:53 AM
 */
public class ArrayLIstUse {
    public static void main(String[] args) {

        ArrayList<String> lis = new ArrayList<String>();
        lis.add("google");
        lis.add("Mysql");
        lis.add("redis");
        lis.add("linux");
        System.out.println(lis);
        System.out.println(lis.size());
        System.out.println(lis.get(1));
        System.out.println(lis.get(0));
        System.out.println(lis.remove(0));
        System.out.println(lis.size());

        for (String i : lis){
            System.out.println(i);
        }

    }
}
