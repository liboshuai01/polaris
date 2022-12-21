package com.liboshuai.mall.tiny.zlearning.Test.literal.day08.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:Sun
 * @date2022/12/1418:55
 */
public class Customer extends User{

    private Map<String ,Boolean> buyMovies = new HashMap<>();


    public Map<String, Boolean> getBuyMovies() {
        return buyMovies;
    }

    public void setBuyMovies(Map<String, Boolean> buyMovies) {
        this.buyMovies = buyMovies;
    }
}
