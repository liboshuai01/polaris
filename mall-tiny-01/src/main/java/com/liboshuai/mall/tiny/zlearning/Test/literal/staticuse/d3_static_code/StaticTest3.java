package com.liboshuai.mall.tiny.zlearning.Test.literal.staticuse.d3_static_code;

import java.util.ArrayList;

/**
 * @author:Sun
 * @date04/12/20221:08 PM
 */
public class StaticTest3 {
    //定义一个静态的集合,这样这个集合只加载一个.因为当前房间只需要一副牌
    public static ArrayList<String> cards = new ArrayList<>();

    static {
        String[] sizes = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        // b、定义一个数组存储全部的花色：类型确定了，个数确定了。
        String[] colors = {"♥", "♠", "♦", "♣"};
        for (int i = 0; i < sizes.length;i++){
            for (int j = 0; j < colors.length;j++){

                String card = sizes[i] + colors[j];
                cards.add(card);
            }

        }
        cards.add("小🃏");
        cards.add("大🃏");
    }

    public static void main(String[] args) {
        System.out.println("新牌：" + cards);
    }

}
