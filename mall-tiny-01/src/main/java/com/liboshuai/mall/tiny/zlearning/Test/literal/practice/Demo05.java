package com.liboshuai.mall.tiny.zlearning.Test.literal.practice;

import java.util.Scanner;

/**
 * @author:Sun
 * @date30/11/20229:06 PM
 */
public class Demo05 {
    public static void main(String[] args) {
        int[] scores = new int[6];

        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<scores.length;i++){
            System.out.println("请输入第："+(i + 1)+"个评委打分:");
            int score = scanner.nextInt();
            scores[i] = score;
        }

        int max = scores[0];
        int min = scores[0];
        int sum = 0;
        for (int i = 0; i < scores.length; i++){
            if (scores[i] > max){
                max = scores[i];
            }
            if (scores[i] < min){
                min = scores[i];
            }
            sum += scores[i];
        }
        System.out.println("最高分:"+max);
        System.out.println("最低分:"+min);

        //统计平均分
        double result = (sum - max - min) * 1.0 /(scores.length - 2);
        System.out.println("选手最终的分是:"+result);
    }
}
