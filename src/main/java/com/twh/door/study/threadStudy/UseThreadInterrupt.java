package com.twh.door.study.threadStudy;

public class UseThreadInterrupt {
        public static void main(String[] args) {
            Thread t1 = new Thread("why"){
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int i = 1; i <= 5; i++) {
                        System.out.println(getName() + "   i=" + i);
                    }
                }
            };
            t1.start();
            t1.interrupt(); // 看到程序执行的之后,就不回你再停留5秒才走循环体. 线程状态被中断会异常,但是咱们使用try...catch处理异常,程序出了异常还能继续执行.
        }
}
