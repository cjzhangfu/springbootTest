package com.ifeng.soft.lock;

/**
 * <p>TODO</p>
 *
 * @author zhangfu
 * @date 2023/3/20 上午11:56
 */
public class SystemOutPrintTest {
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            System.out.println("zhangfu");
            try {
                Thread.sleep(10000);
                System.out.println("hahahh");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(1000);
        System.out.println("lulu");
    }
}
