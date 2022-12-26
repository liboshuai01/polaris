package com.liboshuai.mall.tiny.zlearning.Test.literal.staticuse.d3_static_code;

/**
 * @author:Sun
 * @date04/12/20221:08 PM
 */
public class StaticDemo1 {
    public static String schoolName;

    /**
     * 静态代码块:有static修饰,属于类,与类一起优先加载一次,自动触发执行
     * 作用:可以用于初始化静态资源
     */
    static {
        System.out.println("------静态代码块被触发执行了------");
        schoolName = "黑马";

    }

    public static void main(String[] args) {
        System.out.println("------main方法执行------");
        System.out.println(schoolName);
    }
}
