package com.liboshuai.mall.admin.zlearning.Test.literal.day06.d4_collection_test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author:Sun
 * @date2022/12/823:13
 */
public class GameDemo {

    public static List<Card> allCards = new ArrayList<>();

    static {
        String[] sizes = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        // 4、定义花色：个数确定，类型确定，使用数组
        String[] colors = {"♠", "♥", "♣", "♦"};
        // 5、组合点数和花色
        int index = 0; // 记录牌的大小


        for (String size : sizes){
            index++;
            for (String color : colors){
                Card c = new Card(size,color,index);
                allCards.add(c);
            }
        }
        Card c1 = new Card("" ,  "🃏", ++index);
        Card c2 = new Card("" ,  "👲",++index);
        Collections.addAll(allCards,c1,c2);
        System.out.println("新牌：" + allCards);

    }

    public static void main(String[] args) {

        Collections.shuffle(allCards);
        System.out.println("洗牌后：" + allCards);

        List<Card> linhuchong = new ArrayList<>();
        List<Card> jiumozhi = new ArrayList<>();
        List<Card> renyingying = new ArrayList<>();

        for (int i = 0; i < allCards.size() - 3; i++){
            Card c = allCards.get(i);
            if (i % 3==0){
                linhuchong.add(c);
            } else if (i % 3 == 1) {
                jiumozhi.add(c);
            } else if ((i & 3) == 2) {
                renyingying.add(c);
            }
        }
        List<Card> lastThreeCards = allCards.subList(allCards.size() - 3 , allCards.size());
        sortCards(linhuchong);
        sortCards(jiumozhi);
        sortCards(renyingying);
        System.out.println("啊冲：" + linhuchong);
        System.out.println("啊鸠：" + jiumozhi);
        System.out.println("盈盈：" + renyingying);
        System.out.println("三张底牌：" + lastThreeCards);

    }
    public static void sortCards(List<Card> cards){
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o2.getIndex() - o1.getIndex();
            }
        });
    }
}
