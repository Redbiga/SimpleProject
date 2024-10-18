package org.example.Demo;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * @author redA
 * @时间: 2024年10月15日 下午7:23
 */
public class 线程异常 {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    @Test
    public void threadLocalTest() {
        // 在主线程中设置值
        threadLocal.set("主线程的值");

        new Thread(() -> {
            // 在子线程中设置不同的值
            threadLocal.set("子线程的值");
            printValue();
        }).start();

        printValue();
    }

    private static void printValue() {
        // 打印当前线程中的ThreadLocal值
        System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
    }
    @Test
    public void FutureExceptionHandling(){
        ExecutorService executor = Executors.newSingleThreadExecutor();

        // 使用Callable，可以抛出异常
        Callable<String> task = () -> {
            throw new IllegalStateException("出现异常！");
        };

        Future<String> future = executor.submit(task);

        try {
            // 获取结果，如果有异常会在这里抛出
            future.get();
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            System.out.println("捕获到异常: " + cause.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // 重新设置中断状态
        } finally {
            executor.shutdown();
        }
    }
    @Test
    public void solution(){
        // 创建一个会抛出异常的任务
        Runnable taskWithException = () -> {
            throw new RuntimeException("线程内部异常");
        };

// 设置一个异常处理器
        Thread.UncaughtExceptionHandler handler = (thread, throwable) -> {
            System.out.println(thread.getName() + " 抛出了异常: " + throwable.getMessage());
        };

// 在子线程中运行任务，并设置异常处理器
        Thread threadWithHandler = new Thread(taskWithException);
        threadWithHandler.setUncaughtExceptionHandler(handler);
        threadWithHandler.start();
    }
    public static void main(String[] args) {
        // 创建一个任务，会抛出异常
        Runnable task = () -> {
            throw new RuntimeException("线程内部异常");
        };

        // 在主线程中启动一个子线程执行任务
        Thread thread = new Thread(task);

        try {
            thread.start();
            thread.join(); // 等待子线程结束
        } catch (InterruptedException e) {
            System.out.println("主线程被中断了");
        } catch (Exception e) {
            System.out.println("子线程中抛出了异常");
        }
        System.out.println("主线程继续执行");
    }


}