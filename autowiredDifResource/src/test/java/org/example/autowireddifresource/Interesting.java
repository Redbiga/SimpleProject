package org.example.autowireddifresource;

import lombok.extern.slf4j.Slf4j;

/**
 * @author redA
 * @时间: 2024年11月15日 下午4:25
 */
@Slf4j
public class Interesting {
    volatile int a = 1;
    volatile int b = 1;
   synchronized public void add() {
        log.info("add start");
        for (int i = 0; i < 10000; i++) {
            a++;
            b++;
        }
        log.info("add done");
    }
   synchronized public void compare() {
        log.info("compare start");
        for (int i = 0; i < 10000; i++) {
            //a始终等于b吗？
            if (a < b) {
                log.info("a:{},b:{},{}", a, b, a > b);
                //最后的a>b应该始终是false吗？
            }
        }
        log.info("compare done");
    }

    public static void main(String[] args) {
        Interesting interesting = new Interesting();
        new Thread(() -> interesting.add()).start();
        new Thread(() -> interesting.compare()).start();
    }
}