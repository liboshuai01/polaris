package com.liboshuai.mall.tiny.zlearning.Test.literal.array;

/**
 * @author:Sun
 * @date30/11/202210:53 AM
 */
public class Demo07 {
    public static void main(String[] args) {
        int [] faceScore = {15,9000,10000,20000,-5};

        int max = faceScore[0];

        for (int i = 0; i < faceScore.length;i++){
            if (max<faceScore[i]){
                max = faceScore[i];
            }


        }
        System.out.println("最大值："+max);
    }
}
