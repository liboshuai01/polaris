package com.liboshuai.mall.admin.zlearning.Test.literal.staticuse.d9_extends_override;

/**
 * @author:Sun
 * @date04/12/20222:03 PM
 */
public class Test {
    public static void main(String[] args) {
        NewPhone newPhone = new NewPhone();
        newPhone.call();
        newPhone.sendMsg();

    }
}


class NewPhone extends Phone{

    @Override
    public  void call(){
        super.call();
        System.out.println("开始视频电话");
    }
    @Override
    public void sendMsg(){
        super.sendMsg();
        System.out.println("发送有趣的图片");
    }

/*    @Override
    public static void test(){

    }*/

}


class Phone{

    public void  call(){
        System.out.println("打电话");
    }
    public void sendMsg(){
        System.out.println("发短信");
    }
    public static void test(){

    }
}