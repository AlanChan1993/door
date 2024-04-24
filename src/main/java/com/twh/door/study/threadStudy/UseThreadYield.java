package com.twh.door.study.threadStudy;

public class UseThreadYield {
        public static void main(String[] args) {
            Thread t1 = new Thread("任务1") {
                @Override
                public void run() {
                    for (int i = 0; i < 50; i++) {
                        // 任务1碰到偶数就礼让
                        if(i % 2 == 0) {
                            Thread.yield();
                        }
                        System.out.println(getName()+"------" + i);
                    }
                }
            };
            Thread t2 = new Thread("任务2") {
                @Override
                public void run() {
                    for (int i = 0; i < 50; i++) {
                        System.out.println(getName()+"------" + i);
                    }
                }
            };
            // t1和t2的优先级一样,都是5,能触发yield方法.
            t1.start();
            t2.start();
        }
}
