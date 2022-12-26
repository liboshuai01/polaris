package com.liboshuai.mall.tiny.zlearning.Test.literal.api_lambda_app.collection_app.d10_genericity_interface;

/**
 * @author:Sun
 * @date2022/12/822:25
 */
public interface Data<E> {
    void add(E e);
    void delete(int id);
    void update(E e);
    E queryById(int id);
}
