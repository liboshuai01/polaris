package com.liboshuai.mall.admin.zlearning.Test.literal.staticuse.d3_static_code;

/**
 * @author:Sun
 * @date04/12/20221:08 PM
 */
public class StaticDemo2 {
    private String name;

    public StaticDemo2(){System.out.println("===无参构造器被触发执行==");}

    /**
     * 实例代码块:无static修饰,属于对象,每次构建对象都会触发执行一次
     * 初始化实例资源
     */
    {
        name = "zs";
        System.out.println("===实例代码块被触发执行===");
    }

    public static void main(String[] args) {
        StaticDemo2 s1 = new StaticDemo2();
        System.out.println(s1.name);

        StaticDemo2 s2 = new StaticDemo2();
        System.out.println(s2.name);
    }
}
