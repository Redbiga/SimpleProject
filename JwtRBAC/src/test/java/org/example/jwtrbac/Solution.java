package org.example.jwtrbac;

/**
 * @author redA
 * @时间: 2024年10月11日 下午9:18
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(  get());
//      get1();
    }
    public  static int get(){
        int a=10;
        try {
            System.out.println(a/0);
            a=20;
        }catch (ArithmeticException e){
            a=30;
            return a;
        }finally {
            a=40;
        }
        return a;
    }
    public static int get1(){
        int num = 0;
        for(int i =0;i<100;i++){
            num= num++;
        }
        System.out.println(num);
        return num;
    }

}
/*
*如果 finally 块中没有 return 语句，那么最终返回值是 try 块中返回的 value（即 1）。
如果在 finally 块中存在 return 语句，则返回 finally 块中指定的值（在本例中是 3）。
* public class TryCatchFinallyExample {
    public static void main(String[] args) {
        System.out.println(testMethod());
    }

    public static int testMethod() {
        int value = 0;

        try {
            value = 1; // 1. 在 try 块中进行某些操作
            return value; // 2. 返回 value（1），但并不立即结束方法
        } catch (Exception e) {
            value = 2; // 3. 如果发生异常，这里会执行
            return value; // 4. 返回 value（2）
        } finally {
            value = 3; // 5. finally 块总是会执行
            // 6. 如果在 finally 块中有 return，将覆盖 try 或 catch 中的 return
            // return value; // 如果取消注释，这将返回 3
        }
    }
}

* */