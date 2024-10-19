package org.example.Demo;

/**
 * @author redA
 * @时间: 2024年10月19日 下午10:58
 */
public class 主类线程 extends Thread{
    public static void main(String[] args) {
        主类线程 t= new 主类线程();
        t.run();
    }
    public  void start() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(i);
        }
    }
}