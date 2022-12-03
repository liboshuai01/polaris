package com.liboshuai.mall.tiny.zlearning.Test.literal.ATM;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author:Sun
 * @date03/12/202210:19 AM
 */
public class ATMSystem {
    public static void main(String[] args) {

    }
    /**
     * 用户的开户操作
     * */
    private static void login(ArrayList<Account> accounts, Scanner sc) {
        System.out.println("===================系统登录操作========================");
        if (accounts.size() == 0){
            System.out.println("对不起，当前系统中，无任何账户，请先开户，再来登录~~");
            return;
        }
        while(true){
            System.out.println("请您输入登录卡号:");
            String cardId = sc.next();

            Account acc = getAccountByCardId(cardId,accounts);
            if (acc != null){
                while(true){
                    System.out.println("请您输入登录密码：");
                    String passWord = sc.next();
                    if (acc.getPassWord().equals(passWord)){
                        System.out.println("恭喜您，" + acc.getUserName() +"先生/女生进入系统，您的卡号是：" + acc.getCardId());
                        showUserCommand(sc,acc,accounts);
                        return;
                    }else {
                        System.out.println("对不起，您输入的密码有误~~");
                    }
                }
            }else {
                System.out.println("对不起，系统中不存在该账户卡号~~");
            }
        }

    }
    /**
     * 展示页
     * */
    private static void showUserCommand(Scanner sc, Account acc, ArrayList<Account> accounts) {
        while (true){
            System.out.println("===============用户操作页===================");
            System.out.println("1、查询账户");
            System.out.println("2、存款");
            System.out.println("3、取款");
            System.out.println("4、转账");
            System.out.println("5、修改密码");
            System.out.println("6、退出");
            System.out.println("7、注销账户");
            System.out.println("请选择：");

            int command = sc.nextInt();
            switch (command){
                case 1:
                    showAccount(acc);
                    break;
                case 2:
                    depositMoney(acc,sc);
                    break;
                case 3:
                    drawMoney(acc,sc);
                    break;
                case 4:
                    transferMoney(sc,acc,accounts);
                    break;
                case 5:
                    updatePassWord(sc,acc);
                    return;
                case 6:
                    System.out.println("退出成功，欢迎下次光临");
                    return;
                case 7:
                    if (deleteAccount(acc,sc,accounts)){
                        return;
                    }else {
                        break;
                    }
                default:
                    System.out.println("您输入的操作命令不正确");
            }
        }
    }

    /**
     * 销户功能
     */
    private static boolean deleteAccount(Account acc, Scanner sc, ArrayList<Account> accounts) {
        System.out.println("===================用户销户========================");
        System.out.println("您真的要销户？y/n");
        String rs = sc.next();
        switch (rs){
            case "y":
                if (acc.getMoney() > 0){
                    System.out.println("您账户中还有钱没有取完，不允许销户~");
                }else {
                    accounts.remove(acc);
                    System.out.println("你的账号销户完成");
                    return true;
                }
                break;
            default:
                System.out.println("好的，当前账户继续保留~");
        }
        return false;
    }

    /**
     * 修改密码
     * sc :
     * */
    private static void updatePassWord(Scanner sc,Account acc){

    }

    /**
     * 转账功能
     * @param sc 扫描器
     * @param acc  自己的账户对象
     * @param accounts 全部账户的集合。
     */
    private static void transferMoney(Scanner sc, Account acc, ArrayList<Account> accounts) {

    }
    /**
     * 取钱功能
     * */
    private static void drawMoney(Account acc,Scanner sc){

    }
    /**
     * 存钱方法
     */
    private static void depositMoney(Account acc,Scanner sc){

    }
    /**
     * 展示账户信息
     */
    private static void showAccount(Account acc){
        System.out.println("==========当前账户信息如下==========");
        System.out.println("卡号:"+acc.getCardId());
        System.out.println("户主"+acc.getUserName());
        System.out.println("余额:"+acc.getMoney());
        System.out.println("限额:"+acc.getQuotaMoney());
    }
    /**
     * 用户开户功能的实现
     */
    private static void register(ArrayList<Account> accounts,Scanner sc){
        System.out.println("===================系统开户操作========================");
    }
    /**
     * 为账户生成8位与其他账户卡号不同的号码。
     */
    private static String getRandomCardId(ArrayList<Account> accounts){
        Random random = new Random();
        while(true){
            String cardId = "";
            for (int i = 0; i < 8; i++){
                cardId += random.nextInt(10);
            }
            Account acc = getAccountByCardId(cardId,accounts);
            if (acc == null){
                return cardId;
            }
        }
    }
    /**
     * 根据卡号查询出一个账户对象出来
     * @param cardId  卡号
     * @param accounts 全部账户的集合
     * @return  账户对象 | null
     */
    private  static Account getAccountByCardId(String cardId,ArrayList<Account> accounts){
        for (int i = 0; i < accounts.size(); i++){
            Account acc = accounts.get(i);
            if (acc.getCardId().equals(cardId)){
                return acc;
            }
        }
        return null;
    }
}
