package org.example;

/**
 * @author redA
 * @时间: 2024年10月25日 上午10:34
 * @描述: 值传递
 */
public class Main {
    private  static  void  change(StringBuffer a, StringBuffer b) {
        a=b;
        b = new StringBuffer("new world");
        a.append("new world");
    }
    public  static void main(String[] args) {
        StringBuffer str1 = new StringBuffer("hello");
        StringBuffer str2 = new StringBuffer("great ");
        change(str1, str2);
        System.out.println(str1.toString());
        System.out.println(str2.toString());
    }
}