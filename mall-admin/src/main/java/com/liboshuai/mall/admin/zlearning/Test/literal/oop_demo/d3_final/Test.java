package com.liboshuai.mall.admin.zlearning.Test.literal.oop_demo.d3_final;

/**
 * @author:Sun
 * @date05/12/20226:47 PM
 */
public class Test {

    public static final String itName = "黑马";

    private final String name = "猪八戒";

    public static void main(String[] args) {

        final Double rate = 3.14;
        buy(0.8);

        Test t = new Test();
        System.out.println(t.name);
        final Teacher t2 = new Teacher("学习，授课，吹吹水~~");
        
    }
    public static void buy(final double z){
//        z = 0.8;
    }
}

class Teacher{

    private String hobby;

    public Teacher() {
    }

    public Teacher(String hobby) {
        this.hobby = hobby;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
