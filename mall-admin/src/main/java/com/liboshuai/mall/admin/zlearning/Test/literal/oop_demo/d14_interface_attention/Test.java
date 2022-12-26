package com.liboshuai.mall.admin.zlearning.Test.literal.oop_demo.d14_interface_attention;

/**
 * @author:Sun
 * @date05/12/202210:26 PM
 */
public class Test {
    public static void main(String[] args) {

        A.test();
        B.test();

        Zi zi = new Zi();
        zi.go();

        Zi2 zi2 = new Zi2();
        zi2.sing();

    }
}

class Zi2 implements GanDie1,GanDie2{
    @Override
    public void sing() {
        GanDie1.super.sing();
        GanDie2.super.sing();
        System.out.println("我唱给大家听了");
    }
}


interface GanDie1{
    default void sing(){
        System.out.println("干爹1让你唱征服~");
    }
}

interface GanDie2{
    default void sing(){
        System.out.println("干爹2让你唱征服~");
    }
}


class Zi extends Fu implements GanDie{
    public void go(){
        GanDie.super.run();
    }
}


class Fu{
    public void run(){
        System.out.println("亲爹说赶紧跑路~~");
    }
}


interface GanDie{

    default void run(){
        System.out.println("干爹说留在我身边~~");
    }
}


/**
 * 接口
 */
class C implements A,B{

    @Override
    public void run() {

    }
}

interface B{
    void run();
    static void test(){

    }
}
interface A{
    void run();
    static void test(){

    }
}