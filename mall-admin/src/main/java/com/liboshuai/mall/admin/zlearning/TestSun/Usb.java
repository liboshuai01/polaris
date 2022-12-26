package com.liboshuai.mall.admin.zlearning.TestSun;

public class Usb implements UsbInterface {

    @Override
    public void start() {
        System.out.println("Usb开始工作");
    }

    @Override
    public void stop() {
        System.out.println("Usb停止工作");
    }
}
