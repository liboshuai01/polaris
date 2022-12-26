package com.liboshuai.mall.admin.zlearning.Test.literal.staticuse.d4_static_singleinstance;

/**
 * @author:Sun
 * @date04/12/20221:20 PM
 */
public class SingleInstance2 {

    private static SingleInstance2 instance;

    public static  SingleInstance2 getInstance(){
        if (instance == null){
            instance = new SingleInstance2();
        }
        return instance;
    }

    private SingleInstance2(){

    }
}
