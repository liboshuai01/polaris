package com.liboshuai.mall.tiny.zlearning.Test.literal.oop_demo.d5_enum;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author:Sun
 * @date05/12/20229:32 PM
 */
public class Test2 {
    public static void main(String[] args) {

        JFrame win = new JFrame("玛丽");
        win.setSize(400,400);

        JPanel jPanel = new JPanel();
        win.add(jPanel);

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
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                move(Constant.RIGHT);
            }
        });
        win.setLocationRelativeTo(null);
        win.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        win.setVisible(true);

    }

    public static void move(Constant orientation){
        switch(orientation){
            case UP:
                System.out.println("玛丽往↑飞了一下~~");
                break;
            case DOWN:
                System.out.println("玛丽往↓蹲了一下~~");
                break;
            case LEFT:
                System.out.println("玛丽往←跑了一下~~");
                break;
            case RIGHT:
                System.out.println("玛丽往→跑了一下~~");
                break;

        }
    }
}
