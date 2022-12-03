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

    }
    /**
     * 展示页
     * */
    private static void showUserCommand(Scanner sc, Account acc, ArrayList<Account> accounts) {

    }

    /**
     * 销户功能
     */
    private static boolean deleteAccount(Account acc, Scanner sc, ArrayList<Account> accounts) {
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
