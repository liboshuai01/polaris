package com.liboshuai.mall.admin.zlearning.Test.literal.api_lambda_app.d9_lambda;

import javax.swing.*;
import java.util.Arrays;

/**
 * @author:Sun
 * @date06/12/202210:48 PM
 */
public class LambdaDemo3 {
    public static void main(String[] args) {
        Integer[] ages1 = {34, 12, 42, 23};

        Arrays.sort(ages1,((o1, o2) -> o2 - o1));
        System.out.println(Arrays.toString(ages1));
        System.out.println("---------------------------");

        JFrame win = new JFrame("登录界面");
        JButton btn = new JButton("我是一个很大的按钮");
        btn.addActionListener(e -> System.out.println("有人点我，点我，点我！！"));
        win.add(btn);
        win.setSize(400, 300);
        win.setVisible(true);

    }
}
