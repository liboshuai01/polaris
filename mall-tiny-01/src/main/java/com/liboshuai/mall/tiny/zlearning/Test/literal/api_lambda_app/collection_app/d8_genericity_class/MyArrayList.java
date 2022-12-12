package com.liboshuai.mall.tiny.zlearning.Test.literal.api_lambda_app.collection_app.d8_genericity_class;

import java.util.ArrayList;

/**
 * @author:Sun
 * @date2022/12/822:11
 */
public class MyArrayList <E>{
    private ArrayList lists = new ArrayList();

    public void add(E e){
        lists.add(e);
    }

    public void remove(E e){
        lists.remove(e);
    }

    @Override
    public String toString() {
        return lists.toString();
    }

}
