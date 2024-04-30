package com.twh.door.study.threadStudy;

public class UseThreadPriority {
        public static void main(String[] args) {
            Thread t1 = new Thread("线程1") {
                @Override
                public void run() {
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(getName() + "----" + i);
                    }
                }
            };
            Thread t2 = new Thread("线程2") {
                @Override
                public void run() {
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(getName() + "----" + i);
                    }
                }
            };
            // 获取线程对象默认优先级
            System.out.println(t1.getPriority()); // 5
            System.out.println(t2.getPriority()); // 5
            /* // 练习:获取主线程优先级
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + "----" + t.getPriority()); // main----5*/
            // 设置线程优先级 数字必须是[1, 10] 超出范围就会报错
            t2.setPriority(Thread.MAX_PRIORITY);
            t1.setPriority(Thread.MIN_PRIORITY);

            t1.start();
            t2.start();
        }
}
