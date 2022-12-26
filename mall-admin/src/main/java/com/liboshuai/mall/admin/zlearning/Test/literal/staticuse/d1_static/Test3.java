package com.liboshuai.mall.admin.zlearning.Test.literal.staticuse.d1_static;

/**
 * @author:Sun
 * @date04/12/202212:31 PM
 */
public class Test3 {

    /**
     * 静态成员
     */
    public static int onlineNumber = 10;

    public static void test2(){System.out.println("==test2==");}
    /**
     * 实例成员
     */
    private String name;
    public void run(){System.out.println(name + "跑的快~~");}

    //静态方法中不可以出现this关键字
    public static void test3(){}

    //实例方法可以访问静态成员,也可以访问实例成员
    public void go(){
        System.out.println(Test3.onlineNumber);
        System.out.println(onlineNumber);
        test2();
        System.out.println(name);
        System.out.println(this);
        run();
    }

}
