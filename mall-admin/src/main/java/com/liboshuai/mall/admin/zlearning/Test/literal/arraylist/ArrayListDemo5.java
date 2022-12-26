package com.liboshuai.mall.admin.zlearning.Test.literal.arraylist;

import java.util.ArrayList;

/**
 * @author:Sun
 * @date02/12/202211:44 PM
 */
public class ArrayListDemo5 {
    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();

        movies.add(new Movie("《肖生克的救赎》", 9.7 , "罗宾斯"));
        movies.add(new Movie("《霸王别姬》", 9.6 , "张国荣、张丰毅"));
        movies.add(new Movie("《阿甘正传》", 9.5 , "汤姆.汉克斯"));


        System.out.println(movies);

        for (int i = 0; i < movies.size(); i++){
            Movie movie = movies.get(i);
            System.out.println("片名：" + movie.getName());
            System.out.println("评分：" + movie.getScore());
            System.out.println("主演：" + movie.getActor());
        }

    }
}
