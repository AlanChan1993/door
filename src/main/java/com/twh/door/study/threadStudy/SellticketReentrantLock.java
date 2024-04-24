package com.twh.door.study.threadStudy;

import java.util.concurrent.locks.ReentrantLock;

public class SellticketReentrantLock implements Runnable{
        // 定义变量模拟要卖的100张票
        private int ticket = 100;
        // 创建一个锁对象属性
        private ReentrantLock l = new ReentrantLock();

        @Override
        public void run() {
            while (ticket > 0) {
                l.lock(); // 获取锁对象
                if (ticket > 0) {
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + "---卖出的是第" +(ticket + 1) + "张, 剩余" + ticket + "张");
                }
                l.unlock();
            }
        }


    // 线程安全问题演示
        public static void main(String[] args) {
            // 卖票任务
            SellticketReentrantLock st = new SellticketReentrantLock();
            // 创建3个线程对象,模拟三个窗口
            Thread t1 = new Thread(st, "窗口1");
            Thread t2 = new Thread(st, "窗口2");
            Thread t3 = new Thread(st, "窗口3");
            t1.start();
            t2.start();
            t3.start();
        }
}
