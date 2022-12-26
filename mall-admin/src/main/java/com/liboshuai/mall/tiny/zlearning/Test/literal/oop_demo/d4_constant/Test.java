package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_demo.d4_constant;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author:Sun
 * @date05/12/20227:02 PM
 */
public class Test {
    public static void main(String[] args) {

        //创建窗口
        JFrame win = new JFrame("超级玛丽");
        win.setSize(300,200);

        //设计一个面板
        JPanel jPanel = new JPanel();
        win.add(jPanel);

        //放置几个按钮
        JButton b1 = new JButton("上");
        jPanel.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(Constant.UP);
            }
        });

        JButton b2 = new JButton("下");
        jPanel.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(Constant.DOWN);
            }
        });

        JButton b3 = new JButton("左");
        jPanel.add(b3);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(Constant.LEFT);
            }
        });

        JButton b4 = new JButton("右");
        jPanel.add(b4);
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(Constant.RIGHT);
            }
        });

        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        win.setVisible(true);

    }

    public static void move(int orientation){
        switch (orientation){
            case Constant.UP:
                System.out.println("玛丽往↑飞了一下~~");
            case Constant.DOWN:
                System.out.println("玛丽往↓蹲了一下~~");
                break;
            case Constant.LEFT:
                System.out.println("玛丽往←跑了一下~~");
                break;
            case Constant.RIGHT:
                System.out.println("玛丽往→跑了一下~~");
                break;
        }
    }

}
