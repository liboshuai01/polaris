package com.liboshuai.mall.tiny.TestSun;

public class Computer {

    public void transfer(UsbInterface ui) {
        ui.start();
        System.out.println("传输中的细节");
        ui.stop();
    }
}
