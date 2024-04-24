package com.twh.door.study.threadStudy;

public class SellTicketRunnable implements Runnable {
    // 定义变量模拟要卖的100张票
    private int ticket = 100;

    @Override
    public void run() {
        while (ticket > 0) {
            // 卖出一张票数-1
            ticket--;
            System.out.println(Thread.currentThread().getName() + "---卖出的是第" + (ticket + 1) + "张, 剩余" + ticket + "张");
        }
    }


    // 线程安全问题演示
        public static void main(String[] args) {
            // 卖票任务
            SellTicketRunnable st = new SellTicketRunnable();
            // 创建3个线程对象,模拟三个窗口
            Thread t1 = new Thread(st, "窗口1");
            Thread t2 = new Thread(st, "窗口2");
            Thread t3 = new Thread(st, "窗口3");
            Thread t4 = new Thread(st, "窗口4");
            Thread t5 = new Thread(st, "窗口5");
            Thread t6 = new Thread(st, "窗口6");
            Thread t7 = new Thread(st, "窗口7");
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t5.start();
            t6.start();
            t7.start();
        }
}