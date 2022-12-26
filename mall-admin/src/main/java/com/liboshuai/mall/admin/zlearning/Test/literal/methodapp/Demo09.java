package com.liboshuai.mall.admin.zlearning.Test.literal.methodapp;

/**
 * @author:Sun
 * @date30/11/20221:49 PM
 */
public class Demo09 {
    public static void main(String[] args) {
        fire();
        fire("111");
        fire("111",2);
    }
    public static void fire(){
        fire("222");
    }
    public static  void fire(String location){
        fire(location,1);
    }
    public static  void fire(String location, int number){
        System.out.println("默认发射"+number+"枚武器给"+location+"~~~");
    }

}
