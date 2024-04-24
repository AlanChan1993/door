package com.twh.door.study.threadStudy;

public class SellTicketRunnableSafe implements Runnable{
        // 定义变量模拟要卖的100张票
        private int ticket = 100;
        @Override
        public void run() {
            while (ticket > 0) {
                sell();
            }
        }

// 把卖票的过程抽取出来定义到一个成员方法中
// 咱们写的一个成员方法sell,这个方法内部所有的代码都使用同步代码块给包裹了,并且使用的锁对象是this的时候
// 这种写法可以使用同步成员方法简化
/* public void sell() {
synchronized (this) { // this-->st
if (ticket > 0 ){
ticket--;
System.out.println(Thread.currentThread().getName() + "---卖出的是第" +
(ticket + 1) + "张, 剩余" + ticket + "张");
}
}
}*/


        // 这就是同步方法. 同步成员方法的锁对象就是this. 简化的就是上面sell中的代码
        public synchronized void sell() {
            if (ticket > 0 ){
                ticket--;
                System.out.println(Thread.currentThread().getName() + "---卖出的是第" + (ticket + 1) + "张, 剩余" + ticket + "张");
            }
        }

        public static void main(String[] args) {
            // 卖票任务
            SellTicketRunnableSafe st = new SellTicketRunnableSafe();
            // 创建3个线程对象,模拟三个窗口
            Thread t1 = new Thread(st, "窗口1");
            Thread t2 = new Thread(st, "窗口2");
            Thread t3 = new Thread(st, "窗口3");
            t1.start();
            t2.start();
            t3.start();
        }
}
