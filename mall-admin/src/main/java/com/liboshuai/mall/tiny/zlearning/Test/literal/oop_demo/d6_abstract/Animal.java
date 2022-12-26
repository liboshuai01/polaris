package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_demo.d6_abstract;

/**
 * @author:Sun
 * @date05/12/20229:42 PM
 */
public abstract class Animal {
    private String name;
    public abstract  void run();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
