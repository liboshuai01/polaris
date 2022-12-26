package com.liboshuai.mall.admin.zlearning.Test.literal.ATM;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author:Sun
 * @date03/12/202210:19 AM
 */
public class ATMSystem {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("===============黑马ATM系统=================");
            System.out.println("1、账户登录");
            System.out.println("2、账户开户");

            System.out.println("请您选择操作：");
            int command = sc.nextInt();
            switch (command){
                case 1:
                    login(accounts,sc);
                    break;
                case 2:
                    register(accounts,sc);
                    break;
                default:
                    System.out.println("您输入的操作命令不存在~~");
            }
        }

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
        System.out.println("===================用户密码修改========================");
        while(true){
            System.out.println("请您输入当前密码：");
            String passWord = sc.next();
            if (acc.getPassWord().equals(passWord)){
                while(true){
                    System.out.println("请您输入新密码:");
                    String newPassWord = sc.next();

                    System.out.println("请您确认新密码:");
                    String okPassWord = sc.next();
                    if (newPassWord.equals(okPassWord)){
                        acc.setPassWord(newPassWord);
                        System.out.println("恭喜您，您密码修改成功了~~");
                        return;
                    }else {
                        System.out.println("您输入的2次密码不一致~~");
                    }

                }
            }else {
                System.out.println("您输入的密码不正确~");
            }
        }

    }

    /**
     * 转账功能
     * @param sc 扫描器
     * @param acc  自己的账户对象
     * @param accounts 全部账户的集合。
     */
    private static void transferMoney(Scanner sc, Account acc, ArrayList<Account> accounts) {
        System.out.println("===================用户转账操作========================");
        if (accounts.size() < 2){
            System.out.println("当前系统中，不足2个账户，不能进行转账，请去开户吧~~");
            return;
        }
        if (acc.getMoney() == 0){
            System.out.println("对不起，您自己都都没钱，就别转了吧~~");
            return;
        }
        while(true){
            System.out.println("请您输入对方账户的卡号");
            String cardId = sc.next();

            if (cardId.equals(acc.getCardId())){
                System.out.println("对不起，您不可以给自己进行转账~~");
                continue;
            }
            Account account = getAccountByCardId(cardId,accounts);
            if (account == null){
                System.out.println("对不起，您输入对方的这个账号不存在~~");
            }else {
                String userName = account.getUserName();
                String tip = "*" + userName.substring(1);
                System.out.println("请您输入["+ tip +"]的姓氏");
                String preName = sc.next();

                if (userName.startsWith(preName)){
                    while(true){
                        System.out.println("请您输入转账金额：");
                        double money = sc.nextDouble();
                        if (money > acc.getMoney()){
                            System.out.println("对不起，您余额不足，您最多可以转账：" + acc.getMoney());
                        }else {
                            acc.setMoney(acc.getMoney()-money);
                            account.setMoney(account.getMoney()+money);
                            System.out.println("转账成功！您的账户还剩余：" + acc.getMoney());
                            return;
                        }
                    }
                }else {
                    System.out.println("对不起，您输入的信息有误~~");
                }
            }
        }
    }
    /**
     * 取钱功能
     * */
    private static void drawMoney(Account acc,Scanner sc){
        System.out.println("===================用户取钱操作========================");
        if (acc.getMoney() < 100){
            System.out.println("对不起，当前账户中不够100元，不能取钱~");
            return;
        }
        while(true){
            System.out.println("请您输入取款金额：");
            double money = sc.nextDouble();
            if (money > acc.getQuotaMoney()){
                System.out.println("对不起，您当前取款金额超过每次限额，每次最多可取：" + acc.getQuotaMoney());
            }else {
                if (money > acc.getMoney()){
                    System.out.println("余额不足，您账户目前总余额是：" + acc.getMoney());
                }else {
                    System.out.println("恭喜您，取钱" + money +"元，成功！");
                    acc.setMoney(acc.getMoney() - money);
                    showAccount(acc);
                    return;
                }
            }
        }

    }
    /**
     * 存钱方法
     */
    private static void depositMoney(Account acc,Scanner sc){
        System.out.println("===================用户存钱操作========================");
        System.out.println("请您输入存款金额：");
        double money = sc.nextDouble();
        acc.setMoney(acc.getMoney()+money);
        System.out.println("恭喜您，存钱成功，当前账户信息如下：");
        showAccount(acc);
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
        Account account = new Account();

        System.out.println("请您输入账户用户名:");
        String userName = sc.next();
        account.setUserName(userName);
        while(true){
            System.out.println("请您输入账户密码：");
            String passWord = sc.next();
            System.out.println("请您输入确认密码：");
            String okPassWord = sc.next();
            if (passWord.equals(okPassWord)){
                account.setPassWord(passWord);
                break;
            }else {
                System.out.println("对不起，您输入的2次密码不一致，请重新确认~~");
            }
        }
        System.out.println("请您输入账户当次限额：");
        double quotaMoney = sc.nextDouble();
        account.setQuotaMoney(quotaMoney);

        String carId = getRandomCardId(accounts);
        account.setCardId(carId);
        System.out.println("恭喜您，" + userName + "先生/女生，您开户成功，您的卡号是：" + carId + "，请您妥善保管卡号" );
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
