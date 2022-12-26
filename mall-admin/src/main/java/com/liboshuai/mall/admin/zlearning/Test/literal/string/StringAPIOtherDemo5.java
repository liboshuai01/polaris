package com.liboshuai.mall.admin.zlearning.Test.literal.string;

/**
 * @author:Sun
 * @date03/12/202212:39 AM
 */
public class StringAPIOtherDemo5 {
    public static void main(String[] args) {

        String name = "我爱你中国love";
        System.out.println(name.length());

        char c = name.charAt(1);
        System.out.println(c);

        System.out.println("----------------");
        for (int i = 0; i < name.length(); i++){
            char ch = name.charAt(i);
            System.out.println(ch);
        }
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++){
            char ch = chars[i];
            System.out.println(ch);
        }

        String name2 = "Java是最厉害的编程语言";
        String rs = name2.substring(0,9);
        System.out.println(rs);

        String rs1 = name2.substring(4, 9);
        System.out.println(rs1);

        String rs2 = name2.substring(4);
        System.out.println(rs2);

        String name3 = "金三胖是最厉害的80后，金三胖棒棒的！我好爱金三胖";
        String rs3 = name3.replace("金三胖","***");
        System.out.println(rs3);

        System.out.println(name3.contains("金三胖"));
        System.out.println(name3.contains("金二胖"));

        System.out.println(name3.startsWith("金三胖"));
        System.out.println(name3.startsWith("金三胖是最厉害"));
        System.out.println(name3.startsWith("金三胖是最厉害2"));

        String name4 = "王宝强,贾乃亮,陈羽凡";
        String[] names = name4.split(",");
        for (int i = 0;i < names.length;i++){
            System.out.println("选择了："+ names[i]);
        }

    }
}
