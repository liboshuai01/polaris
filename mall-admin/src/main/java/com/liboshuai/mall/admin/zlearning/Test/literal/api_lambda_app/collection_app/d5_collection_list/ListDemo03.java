package com.liboshuai.mall.admin.zlearning.Test.literal.api_lambda_app.collection_app.d5_collection_list;

import java.util.LinkedList;

/**
 * @author:Sun
 * @date06/12/202211:28 PM
 */
public class ListDemo03 {
    public static void main(String[] args) {


        LinkedList<String> queue = new LinkedList<>();
        queue.addLast("1号");
        queue.addLast("2号");
        queue.addLast("3号");

        System.out.println(queue);
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue);

        LinkedList<String> stack = new LinkedList<>();
        stack.push("第1颗子弹");
        stack.push("第2颗子弹");
        stack.push("第3颗子弹");
        stack.push("第4颗子弹");
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack);


    }
}
