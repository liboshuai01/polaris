package com.liboshuai.mall.tiny.zlearning.Test.literal.day07.d2_stream;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:Sun
 * @date2022/12/1220:58
 */
public class StreamDemo04 {

    public static double allMoney;
    public static double allMoney2;


    public static void main(String[] args) {

        List<Employee> one = new ArrayList<>();
        one.add(new Employee("猪八戒",'男',30000 , 25000, null));
        one.add(new Employee("孙悟空",'男',25000 , 1000, "顶撞上司"));
        one.add(new Employee("沙僧",'男',20000 , 20000, null));
        one.add(new Employee("小白龙",'男',20000 , 25000, null));

        List<Employee> two = new ArrayList<>();
        two.add(new Employee("武松",'男',15000 , 9000, null));
        two.add(new Employee("李逵",'男',20000 , 10000, null));
        two.add(new Employee("西门庆",'男',50000 , 100000, "被打"));
        two.add(new Employee("潘金莲",'女',3500 , 1000, "被打"));
        two.add(new Employee("武大郎",'女',20000 , 0, "下毒"));


        Topperformer t = one.stream().max((e1,e2) -> Double.compare(e1.getSalary() + e1.getBonus(),e2.getBonus()+e2.getSalary())).map(e -> new Topperformer(
                e.getName(),
                e.getSalary()+e.getBonus()
        )).get();

        System.out.println(t);

//        one.stream().sorted((e1,e2) -> Double.compare())


    }
}
