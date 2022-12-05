package com.liboshuai.mall.tiny.zlearning.arraylist;

import java.util.ArrayList;

/**
 * @author:Sun
 * @date02/12/202211:41 PM
 */
public class ArrayListDemo4 {
    public static void main(String[] args) {
        ArrayList<Integer> scores = new ArrayList<>();

        scores.add(98);
        scores.add(77);
        scores.add(66);
        scores.add(89);
        scores.add(79);
        scores.add(50);
        scores.add(100);

        System.out.println(scores);

        for (int i =0; i < scores.size(); i++){

            if (scores.get(i) <= 80){
                scores.remove(i);
            }
            System.out.println(scores.get(i));
        }
    }
}
