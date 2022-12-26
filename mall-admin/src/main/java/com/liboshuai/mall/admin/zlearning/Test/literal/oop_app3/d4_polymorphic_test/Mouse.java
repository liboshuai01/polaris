package com.liboshuai.mall.admin.zlearning.Test.literal.oop_app3.d4_polymorphic_test;

/**
 * @author:Sun
 * @date05/12/202211:00 PM
 */
public class Mouse implements USB{

    private String name;

    public Mouse(String name) {
        this.name = name;
    }

    @Override
    public void connect() {
        System.out.println(name + "成功的接入了设备了~~~");
    }

    @Override
    public void unconnect() {
        System.out.println(name + "成功的从设备弹出了~~~");
    }

    //独有功能
    public void click(){
        System.out.println(name + "双击点亮小红心~~~~");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
