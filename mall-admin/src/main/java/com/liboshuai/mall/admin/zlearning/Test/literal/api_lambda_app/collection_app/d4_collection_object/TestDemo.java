package com.liboshuai.mall.admin.zlearning.Test.literal.api_lambda_app.collection_app.d4_collection_object;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author:Sun
 * @date06/12/202211:23 PM
 */
public class TestDemo {
    public static void main(String[] args) {

        Collection<Movie> movies = new ArrayList<>();
        movies.add(new Movie("《你好，李焕英》", 9.5, "张小斐,贾玲,沈腾,陈赫"));
        movies.add(new Movie("《唐人街探案》", 8.5, "王宝强,刘昊然,美女"));
        movies.add(new Movie("《刺杀小说家》",8.6, "雷佳音,杨幂"));

        System.out.println(movies);

        for (Movie movie : movies){
            System.out.println("片名：" + movie.getName());
            System.out.println("得分：" + movie.getScore());
            System.out.println("主演：" + movie.getActor());
        }
    }
}
