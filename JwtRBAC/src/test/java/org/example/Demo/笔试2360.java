package org.example.Demo;

import java.util.Scanner;
/**
* @题目：
 * <img src = "https://fastly.jsdelivr.net/gh/Redbiga/imgs@main/1729351273373fc1ae0886b11f18777fe23f2a602c81.jpg">
* */
public class 笔试2360 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String equation = scanner.next();
            boolean canBeFixed = checkEquation(equation);
            if (canBeFixed) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    private static boolean checkEquation(String equation) {
        int equalSignIndex = equation.indexOf('=');
        String leftSide = equation.substring(0, equalSignIndex);
        String rightSide = equation.substring(equalSignIndex + 1);

        int leftValue = evaluateExpression(leftSide);
        int rightValue = evaluateExpression(rightSide);

        if (leftValue == rightValue) {
            return true;
        }

        for (int num = 0; num <= 9; num++) {
            for (int insertPos = 0; insertPos <= equation.length(); insertPos++) {
                String newEquation = insertNumber(equation, num, insertPos);
                int newEqualSignIndex = newEquation.indexOf('=');
                String newLeftSide = newEquation.substring(0, newEqualSignIndex);
                String newRightSide = newEquation.substring(newEqualSignIndex + 1);
                int newLeftValue = evaluateExpression(newLeftSide);
                int newRightValue = evaluateExpression(newRightSide);
                if (newLeftValue == newRightValue) {
                    return true;
                }
            }
        }

        return false;
    }

    private static int evaluateExpression(String expression) {
        int value = 0;
        int temp = 0;
        char operator = '+';
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (Character.isDigit(ch)) {
                temp = temp * 10 + (ch - '0');
            } else if (ch == '+' || ch == '*') {
                if (operator == '+') {
                    value += temp;
                } else if (operator == '*') {
                    value *= temp;
                }
                temp = 0;
                operator = ch;
            }
        }
        if (operator == '+') {
            value += temp;
        } else if (operator == '*') {
            value *= temp;
        }
        return value;
    }

    private static String insertNumber(String original, int num, int pos) {
        return original.substring(0, pos) + num + original.substring(pos);
    }
}
