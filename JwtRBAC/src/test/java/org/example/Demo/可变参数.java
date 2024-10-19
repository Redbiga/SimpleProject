package org.example.Demo;

/**
 * @author redA
 * @时间: 2024年10月18日 下午12:45
 */
public class 可变参数 {
    public static void printVariable(String... args) {
        for (String s : args) {
            System.out.println(s);
        }
    }
    public static void printVariable(String arg1, String arg2) {
        System.out.println(arg1 + arg2);
    }
    public static void main(String[] args) {
        printVariable("a", "b");
        printVariable("a", "b", "c", "d");
    }
}