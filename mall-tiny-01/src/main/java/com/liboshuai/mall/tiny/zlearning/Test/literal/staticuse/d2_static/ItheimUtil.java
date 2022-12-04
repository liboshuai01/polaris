package com.liboshuai.mall.tiny.zlearning.Test.literal.staticuse.d2_static;

import java.util.Random;

/**
 * @author:Sun
 * @date04/12/20221:00 PM
 */
public class ItheimUtil {

    /**
     * 工具类无需创建对象,所以把其构造器私有化会显得很专业
     */
    private ItheimUtil(){

    }
    /**
     * 静态方法.
     */
    public static String createVerifyCode(int n){
        //开发一个验证码:
        String code = "";
        String data = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random r = new Random();
        for(int i = 0; i < n; i++){
            int index = r.nextInt(data.length());
            code += data.charAt(index);


        }
        return code;
    }

}
