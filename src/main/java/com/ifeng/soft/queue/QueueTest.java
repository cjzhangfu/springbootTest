package com.ifeng.soft.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>TODO</p>
 *
 * @author zhangfu
 * @date 2023/3/17 下午4:28
 */
public class QueueTest {
    private List<String> queue = new ArrayList<>();
    private final Integer max = 5;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public void put(String s) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            if (queue.size() == max) {
                notFull.await();
            }
            queue.add(s);
            System.out.println("加入元素"+s);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public String take() throws InterruptedException {
        String result="";
        lock.lockInterruptibly();
        try {
            if (queue.size()==0) {
                System.out.println("元素为空，阻塞");
                notEmpty.await();
            }
            result = queue.get(0);
            for (int i = 0;i<queue.size()-1;i++) {
                queue.set(i,queue.get(i+1));
            }
            queue.remove(queue.size()-1);
            notFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        System.out.println("拿出元素"+result);
        return result;
    }
    public static void main(String[] args) {
        QueueTest queueTest = new QueueTest();
        AtomicInteger i= new AtomicInteger();
        new Thread(()->{
            while (true) {
                try {
                    queueTest.put(String.valueOf(i.getAndIncrement()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(()->{
            while (true) {
                try {
                    queueTest.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
