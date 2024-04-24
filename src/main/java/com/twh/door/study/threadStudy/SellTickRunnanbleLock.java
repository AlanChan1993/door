package com.twh.door.study.threadStudy;

public class SellTickRunnanbleLock implements Runnable {
    // 定义变量模拟要卖的100张票
    private int ticket = 100;
    private StringBuilder sb = new StringBuilder();

    @Override
    public void run() {
        while (ticket > 0) { // "a"首先是String对象. 且常量字符串只会在方法区常量池中存储一份.
            // synchronized (new String("a")) { // 这种锁是锁不住的,每次获取锁对象都new一个新的对象.无法同步代码中原子性操作.
            // synchronized (this) { // 外面只创建一个SellTicket对象, 且三个线程绑定的都是这个SellTicket对象. 因此this就只代表外界创建这个st对象. 此时依然能保证锁对象的唯一.
            // synchronized (sb) { sb是SellTicket的一个对象属性,SellTicket在外界只创建了一个st对象,这个st对象sb属性也就只有一个.所以能保证锁对象的唯一.
            synchronized (SellTickRunnanbleLock.class) { // 类名.class就是获取这个类在方法区中加载字节文件之后形成字节码文件对象.一个类字节文件只会在方法区中加载一次.这个类字节文件对象只有一个.它也能充当锁对象
                if (ticket > 0) { // 防止当ticket等于1的时候, 三条线程执行时都满足循环判断
                    // ticket>0成立,进入循环体. 执行同步代码快操作时出现卖负票的情况
                    // 卖出一张票数-1
                    ticket--;
                    System.out.println(Thread.currentThread().getName() + "---卖出的是第" + (ticket + 1) + "张, 剩余" + ticket + "张");
                }
            }
        }
    }

    // 线程安全问题演示
    public static void main(String[] args) {
        // 卖票任务
        SellTickRunnanbleLock st = new SellTickRunnanbleLock();
        // 创建3个线程对象,模拟三个窗口
        Thread t1 = new Thread(st, "窗口1");
        Thread t2 = new Thread(st, "窗口2");
        Thread t3 = new Thread(st, "窗口3");
        Thread t4 = new Thread(st, "窗口4");
        Thread t5 = new Thread(st, "窗口5");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
