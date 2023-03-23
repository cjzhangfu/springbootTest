package com.ifeng.soft.test;

import java.util.concurrent.Semaphore;

/**
 * <p>TODO</p>
 *
 * @author zhangfu
 * @date 2023/3/17 上午11:59
 */

public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("我是线程" + finalI + "，我拿到了锁");
                    Thread.sleep(300000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                    System.out.println("我是线程" + finalI + "，我释放了锁");
                }
            },"线程"+i).start();
        }
    }
}
