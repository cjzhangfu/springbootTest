package com.ifeng.soft.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>TODO</p>
 *
 * @author zhangfu
 * @date 2023/3/17 下午5:28
 */
public class AtomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(100);
        new Thread(()->{
            atomicInteger.compareAndSet(100,200);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicInteger.compareAndSet(200,100);
        }).start();
        new Thread(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
           boolean result =  atomicInteger.compareAndSet(100,300);
            System.out.println(result);
            System.out.println(atomicInteger.get());
        }).start();
    }
}
