package com.liboshuai.mall.tiny.zlearning.forXunHuan;


import java.util.Arrays;
import java.util.List;

/**
 * @Author: liboshuai
 * @Date: 2022-11-28 00:52
 * @Description: ForEach学习代码
 */
public class ForEach {

    /**
     * 主函数, 用于调用其他运行函数代码
     */
    public static void main(String[] args) {
        forEachStringList();
    }


    /**
     * 使用foreach循环遍历一个string类型的list集合
     */
    public static void forEachStringList() {
        List<String> stringList = Arrays.asList("01", "02", "03");
        for (String s :
                stringList) {
            System.out.println("遍历string类型的list集合: " + s);
        }
    }
}
