package com.liboshuai.mall.admin.zlearning.Test.literal.staticuse.d10_extends_constructor;

/**
 * @author:Sun
 * @date04/12/20222:09 PM
 */
public class Dog extends Animal{

    public Dog(){
        super();
        System.out.println("子类Dog无参数构造器被执行");
    }

    public Dog(String name) {
        super();
        System.out.println("子类Dog有参数构造器被执行~");
    }
}
