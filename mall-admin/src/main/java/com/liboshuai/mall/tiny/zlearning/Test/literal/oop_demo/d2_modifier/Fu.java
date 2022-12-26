package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_demo.d2_modifier;

/**
 * @author:Sun
 * @date05/12/20226:36 PM
 */
public class Fu {
    private void privateMethod(){
        System.out.println("-----private-----");
    }
    void method(){
        System.out.println("---缺省--");
    }
    protected void protectedMethod(){
        System.out.println("--protected---");
    }
    public void publicMethod(){
        System.out.println("------public------");
    }

    public static void main(String[] args) {
        Fu f = new Fu();
        f.privateMethod();
        f.protectedMethod();
        f.method();
        f.publicMethod();
    }
}
