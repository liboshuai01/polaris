package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_app3.d8_innerclass_anonymous;

/**
 * @author:Sun
 * @date06/12/202212:05 PM
 */
public class Test2 {
    public static void main(String[] args) {
        Swimming s = new Swimming() {
            @Override
            public void swin() {
                System.out.println("学生快乐的自由泳");
            }
        };
        go(s);
        System.out.println("-----------------");

        Swimming s1 = new Swimming() {
            @Override
            public void swin() {
                System.out.println("老师泳🏊的贼快~~~~~");
            }
        };
        go(s1);

        System.out.println("----------------");

        go(new Swimming() {
            @Override
            public void swin() {
                System.out.println("老师泳🏊的贼快~~~~~");
            }
        });



    }
    public static void go(Swimming s){
        System.out.println("开始。。。");
        s.swin();
        System.out.println("结束。。。");
    }
}

interface Swimming{
    void swin();
}
