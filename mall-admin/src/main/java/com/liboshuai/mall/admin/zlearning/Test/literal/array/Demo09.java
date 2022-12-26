package com.liboshuai.mall.admin.zlearning.Test.literal.array;

import java.util.Random;
import java.util.Scanner;

/**
 * @author:Sun
 * @date30/11/202211:06 AM
 */
public class Demo09 {
    public static void main(String[] args) {
        int[] codes = new int[5];

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < codes.length; i++){
            System.out.println("请您输入第"+(i+1)+"个员工的工号:");
            int code = sc.nextInt();
            codes[i] = code;
        }

        Random random = new Random();
        for (int i = 0;i < codes.length; i++){
            int index = random.nextInt(codes.length);
            System.out.println("index"+index);
            int temp = codes[index];
            codes[index] = codes[i];
            codes[i] = temp;

        }
        for (int code : codes) {
            System.out.println(code + "\t");
        }

    }
}
