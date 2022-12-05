package com.liboshuai.mall.tiny.zlearning.Test.literal.oop.demo;

import java.util.Scanner;

/**
 * @author:Sun
 * @date02/12/20229:52 PM
 */
public class Test {
    public static void main(String[] args) {
        Article[] article = new Article[10];

        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("添加商品:add");
            System.out.println("查看商品：query");
            System.out.println("修改数量：update");
            System.out.println("结算价格：pay");
            System.out.println("请您选择要操作的功能：");

            String command = scanner.next();
            switch (command){
                case "add":
                    addArticle(article);
                    break;
                case "query":
                    queryArticle(article);
                    break;
                case "update":
                    updateArticle(article);
                    break;
                case "pay":
                    calcPayMoney(article);
                    break;
                default:
                    System.out.println("当前命令输入有误");

            }
        }
    }

    private static void calcPayMoney(Article[] articles){
        queryArticle(articles);
        double money = 0;
        for (int i = 0; i < articles.length; i++){
            Article a = articles[i];
            if (a  != null){
                money += (a.price * a.buyNumber);
            }else {
                break;
            }
        }
        System.out.println("本次商品购买的总价为"+money);

    }

    public static void updateArticle(Article[] article){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("请您输入要修改数量的商品名称");
            String name = scanner.next();
            Article a = getArticleByName(name, article);
            if (a != null){
                System.out.println("请您输入修改后购买的数量");
                int buyNumber = scanner.nextInt();
                a.buyNumber = buyNumber;
                System.out.println("该商品的购买数量修改了");
                break;
            }else {
                System.out.println("购物车中没有该商品信息");
            }
        }

    }

    public static Article getArticleByName(String name,Article[] articles){
        for (int i = 0; i < articles.length; i++){
            Article a = articles[i];
            if (a != null && a.name.equals(name)){
                return a;
            }
        }

        return null;
    }

    public static void queryArticle(Article[] articles){
        System.out.println("商品名称\t商品价格\t商品的购买数量");
        for (int i = 0;i <articles.length; i++){
            Article a = articles[i];
            if (a != null){
                System.out.println(a.name + "\t" + a.price + "\t" + a.buyNumber);

            }else {
                return;
            }
        }
    }

    public static void addArticle(Article[] articles){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入商品的名称：");
        String name = scanner.next();
        System.out.println("请输入商品的价格：");
        double price = scanner.nextDouble();
        System.out.println("请输入购买商品的数量：");
        int buNumber = scanner.nextInt();

        Article a = new Article();
        a.name = name;
        a.price = price;
        a.buyNumber = buNumber;

        for (int i = 0; i < articles.length;i++){
            if (articles[i]==null){
                articles[i] = a;
                break;
            }
        }
        System.out.println("添加成功！");
    }
}
