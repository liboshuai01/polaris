package com.liboshuai.mall.admin.zlearning.Test.literal.array;

import java.util.Random;
import java.util.Scanner;

/**
 * @author:Sun
 * @date30/11/202210:57 AM
 */
public class Demo08 {
    public static void main(String[] args) {

        int[] data = new int[5];

        Random r = new Random();
        for (int i = 0; i < data.length; i++){
            data[i] = r.nextInt(20)+1;
        }

        Scanner sc = new Scanner(System.in);
        OUT:
        while(true){
            System.out.println("输入一个1-20的整数进行猜测：");
            int guessData = sc.nextInt();

            for (int i = 0; i<data.length; i++){
                if (data[i] == guessData){
                    System.out.println("ok");
                    break OUT;
                }
            }


        }
        for (int i = 0; i < data.length; i++){
            System.out.println(data[i]);
        }

    }
}
