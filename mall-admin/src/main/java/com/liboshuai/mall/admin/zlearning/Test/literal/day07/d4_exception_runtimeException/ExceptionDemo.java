package com.liboshuai.mall.admin.zlearning.Test.literal.day07.d4_exception_runtimeException;

/**
 * @author:Sun
 * @date2022/12/1323:59
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        System.out.println("程序开始。。。。。。");
        /** 1.数组索引越界异常: ArrayIndexOutOfBoundsException。*/
        int[] arr = {1, 2, 3};
        System.out.println(arr[2]);
        // System.out.println(arr[3]); // 运行出错，程序终止


        //空指针异常
        String name = null;
//        System.out.println(name.length());

        //类型转换异常
        Object o = 23;
//        String s = (String) o;
//        int  c = 10/0;
        String number = "23aabbc";
        Integer it = Integer.valueOf(number);
        System.out.println(it + 1);

        System.out.println("程序结束。。。。。");

    }
}
