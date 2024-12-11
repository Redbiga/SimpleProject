package org.example.Demo;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import static org.springframework.test.context.transaction.TestTransaction.start;

/**
 * @author redA
 * @时间: 2024年10月18日 下午8:32
 */
public class Callable和Runnable的区别 {
    @Test
    public void test(){
/*        new Thread(()->
        {
            System.out.println("hello");
            Integer i = 2/0;
        }
        ).start();*/
    Callable<Integer> callable = ()->
    {
        Integer i = 2/0;
        return 1;
    };
    FutureTask<Integer> futureTask = new FutureTask<>(callable);
    new Thread(futureTask).start();
    }
}