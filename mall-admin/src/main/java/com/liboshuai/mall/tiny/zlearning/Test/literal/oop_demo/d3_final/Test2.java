package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_demo.d3_final;

/**
 * @author:Sun
 * @date05/12/20226:47 PM
 */
public class Test2 {
    public static void main(String[] args) {
        B b = new B();
        b.method();
    }
}

class Student extends People{
//    @Override
//    public void eat(){
//
//    }
}


class People{
    public final void eat(){
        System.out.println("hello");
    }
}
class A{
    public void method(){
        System.out.println("eva");
    }
}
class B extends A{

    @Override
    public void method(){
        super.method();
        System.out.println("明日香");
    }

}