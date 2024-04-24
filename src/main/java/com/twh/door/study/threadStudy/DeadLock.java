package com.twh.door.study.threadStudy;

public class DeadLock {
        // 两个锁对象
        private static final String l1 = "A";
        private static final String l2 = "B";

        public static void main(String[] args) {
            Thread t1 = new Thread("线程1") {
                @Override
                public void run() {
                    synchronized (l1) {
                        try {
                            Thread.sleep(20); // 休眠是为了放大死锁现象出现的概率,让t1和t2更容易交替执行
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (l2) {
                            System.out.println("任务1");
                        }
                    }
                }
            };

            Thread t2 = new Thread("线程2") {
                @Override
                public void run() {
                    synchronized (l2) {
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        synchronized (l1) {
                            System.out.println("任务2");
                        }
                    }
                }
            };
            t1.start();
            t2.start();
        }
}
