package com.liboshuai.mall.tiny.zlearning.Test.literal.api_lambda_app.d2_simpledateformat;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author:Sun
 * @date06/12/20221:22 PM
 */
public class SimpleDateFormatDemo01 {
    public static void main(String[] args) {

        Date d = new Date();
        System.out.println(d);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss EEE a");
        String rs = sdf.format(d);
        System.out.println(rs);


        long time1 = System.currentTimeMillis() + 121 * 1000;
        String rs2 = sdf.format(time1);
        System.out.println(rs2);


    }
}
