package com.example.test.suanfa1;

/**
 * @author : baifuquan
 * @date : 2022/6/21 18:19
 * @className : Demo4
 * @description :
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 * 如：
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 **/
public class Demo4 {

    public static void main(String[] args) {
        String addr = "1.1.1.1";
        String res = defangIPaddr1(addr);
        System.out.println(res);
    }

    public static String defangIPaddr1(String address) {
        char[] chars = new char[address.length() + 6];
        int j = 0;
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) != '.'){
                chars[j++] = address.charAt(i);
            }
            if (address.charAt(i) == '.'){
                chars[j++] = '[';
                chars[j++] = '.';
                chars[j++] = ']';
            }
        }
        return String.valueOf(chars);
    }
}
