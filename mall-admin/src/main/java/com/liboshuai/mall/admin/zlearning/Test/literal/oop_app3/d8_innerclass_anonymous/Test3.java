package com.liboshuai.mall.admin.zlearning.Test.literal.oop_app3.d8_innerclass_anonymous;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author:Sun
 * @date06/12/202212:20 PM
 */
public class Test3 {
    public static void main(String[] args) {
        JFrame win = new JFrame("登录界面");
        JPanel panel = new JPanel();
        win.add(panel);

        JButton btn = new JButton("登录");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(win,"点我一下,说明爱我");
            }

        });


        panel.add(btn);


        win.setSize(300,400);
        win.setLocationRelativeTo(null);
        win.setVisible(true);


    }
}
